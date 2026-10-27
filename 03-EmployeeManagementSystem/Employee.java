public class Employee {
    private final int id;
    private final String name;
    private final String department;
    private final double salary;

    public Employee(int id, String name, String department, double salary) {
        if (id <= 0) throw new IllegalArgumentException("Employee ID must be positive.");
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be empty.");
        if (department == null || department.trim().isEmpty()) throw new IllegalArgumentException("Department cannot be empty.");
        if (salary < 0) throw new IllegalArgumentException("Salary cannot be negative.");

        this.id = id;
        this.name = name.trim();
        this.department = department.trim();
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    public String toFileLine() {
        return id + "|" + name.replace("|", "/") + "|" +
               department.replace("|", "/") + "|" + salary;
    }

    public static Employee fromFileLine(String line) {
        String[] parts = line.split("\\\\|", -1);
        if (parts.length != 4) throw new IllegalArgumentException("Invalid employee record: " + line);
        return new Employee(
            Integer.parseInt(parts[0]),
            parts[1],
            parts[2],
            Double.parseDouble(parts[3])
        );
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Department: %s | Salary: %.2f",
                id, name, department, salary);
    }
}
