import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private static final Path DATA_FILE = Paths.get("employees.txt");
    private static final Map<Integer, Employee> employees = new HashMap<>();

    public static void main(String[] args) {
        loadEmployees();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add employee");
            System.out.println("2. View all employees");
            System.out.println("3. Search employee by ID");
            System.out.println("4. Save employees to file");
            System.out.println("5. Reload employees from file");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1": addEmployee(scanner); break;
                case "2": viewEmployees(); break;
                case "3": searchEmployee(scanner); break;
                case "4": saveEmployees(); break;
                case "5": loadEmployees(); break;
                case "0":
                    saveEmployees();
                    running = false;
                    System.out.println("Data saved. Goodbye!");
                    break;
                default: System.out.println("Invalid option. Please choose again.");
            }
        }
        scanner.close();
    }

    private static void addEmployee(Scanner scanner) {
        try {
            int id = readInt(scanner, "Employee ID: ");
            if (employees.containsKey(id)) {
                System.out.println("That ID already exists. Use a unique ID.");
                return;
            }

            System.out.print("Name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Department: ");
            String department = scanner.nextLine().trim();
            double salary = readDouble(scanner, "Salary: ");

            Employee employee = new Employee(id, name, department, salary);
            employees.put(employee.getId(), employee);
            System.out.println("Employee added successfully.");
        } catch (IllegalArgumentException exception) {
            System.out.println("Invalid employee details: " + exception.getMessage());
        }
    }

    private static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employee records found.");
            return;
        }
        System.out.println("\n--- Employee Records ---");
        for (Employee employee : employees.values()) {
            System.out.println(employee);
        }
    }

    private static void searchEmployee(Scanner scanner) {
        int id = readInt(scanner, "Enter employee ID to search: ");
        Employee employee = employees.get(id);
        if (employee == null) {
            System.out.println("No employee found with ID " + id + ".");
        } else {
            System.out.println(employee);
        }
    }

    private static void saveEmployees() {
        List<Employee> sortedEmployees = new ArrayList<>(employees.values());
        sortedEmployees.sort((first, second) -> Integer.compare(first.getId(), second.getId()));

        try (BufferedWriter writer = Files.newBufferedWriter(DATA_FILE, StandardCharsets.UTF_8)) {
            for (Employee employee : sortedEmployees) {
                writer.write(employee.toFileLine());
                writer.newLine();
            }
            System.out.println("Saved " + sortedEmployees.size() + " employee record(s) to " + DATA_FILE.toAbsolutePath());
        } catch (IOException exception) {
            System.out.println("Error saving employee data: " + exception.getMessage());
        }
    }

    private static void loadEmployees() {
        employees.clear();
        if (!Files.exists(DATA_FILE)) {
            System.out.println("No employees.txt found yet. A new file will be created when you save.");
            return;
        }

        int lineNumber = 0;
        try (BufferedReader reader = Files.newBufferedReader(DATA_FILE, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.trim().isEmpty()) continue;
                try {
                    Employee employee = Employee.fromFileLine(line);
                    employees.put(employee.getId(), employee);
                } catch (IllegalArgumentException exception) {
                    System.out.println("Skipping invalid record at line " + lineNumber + ": " + exception.getMessage());
                }
            }
            System.out.println("Loaded " + employees.size() + " employee record(s).");
        } catch (IOException exception) {
            System.out.println("Error loading employee data: " + exception.getMessage());
        }
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value > 0) return value;
                System.out.println("Enter a whole number greater than 0.");
            } catch (NumberFormatException exception) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (Double.isFinite(value) && value >= 0) return value;
                System.out.println("Enter a valid non-negative salary.");
            } catch (NumberFormatException exception) {
                System.out.println("Invalid salary. Enter a number, such as 35000 or 35000.50.");
            }
        }
    }
}
