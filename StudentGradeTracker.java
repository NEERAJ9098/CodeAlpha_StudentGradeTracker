import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        String highestStudent = "";
        String lowestStudent = "";

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Grade: ");
            double grade = sc.nextDouble();
            sc.nextLine();

            students.add(new Student(name, grade));

            total += grade;

            if (grade > highest) {
                highest = grade;
                highestStudent = name;
            }

            if (grade < lowest) {
                lowest = grade;
                lowestStudent = name;
            }
        }

        double average = total / n;

        System.out.println("\n===== STUDENT REPORT =====");
        System.out.println("Name\t\tGrade");

        for (Student s : students) {
            System.out.println(s.name + "\t\t" + s.grade);
        }

        System.out.println("\n===== SUMMARY =====");
        System.out.printf("Average Score: %.2f\n", average);
        System.out.println("Highest Score: " + highest + " (" + highestStudent + ")");
        System.out.println("Lowest Score: " + lowest + " (" + lowestStudent + ")");

        sc.close();
    }
}