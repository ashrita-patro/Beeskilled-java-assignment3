import java.util.ArrayList;
import java.util.Scanner;

public class StudentMarksRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> marks = new ArrayList<>();

        System.out.print("How many subjects? ");
        int subjects = readPositiveInt(scanner);

        for (int i = 0; i < subjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (0-100): ");
            int mark = readMark(scanner);
            marks.add(mark);
        }

        int highest = marks.get(0);
        int lowest = marks.get(0);
        int total = 0;

        for (int mark : marks) {
            if (mark > highest) highest = mark;
            if (mark < lowest) lowest = mark;
            total += mark;
        }

        double average = (double) total / marks.size();

        System.out.println("\n--- Student Marks Record ---");
        System.out.println("Marks: " + marks);
        System.out.println("Highest marks: " + highest);
        System.out.println("Lowest marks: " + lowest);
        System.out.printf("Average marks: %.2f%n", average);

        scanner.close();
    }

    private static int readPositiveInt(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value > 0) return value;
            } else {
                scanner.next();
            }
            System.out.print("Please enter a whole number greater than 0: ");
        }
    }

    private static int readMark(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value >= 0 && value <= 100) return value;
            } else {
                scanner.next();
            }
            System.out.print("Invalid marks. Enter a value from 0 to 100: ");
        }
    }
}
