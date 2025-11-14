package codsoft;

import java.util.*;

class Student {
    String name;
    String rollNo;
    String grade;

    public Student(String name, String rollNo, String grade) {
        this.name = name;
        this.rollNo = rollNo;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Grade: " + grade;
    }
}

public class StudentManagementSystem {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> removeStudent();
                case 3 -> searchStudent();
                case 4 -> displayAll();
                case 5 -> {
                    System.out.println("👋 Exiting Student Management System.");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addStudent() {
        sc.nextLine(); // clear buffer
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter roll number: ");
        String roll = sc.nextLine();
        System.out.print("Enter grade: ");
        String grade = sc.nextLine();
        students.add(new Student(name, roll, grade));
        System.out.println("✅ Student added successfully!");
    }

    private static void removeStudent() {
        System.out.print("Enter roll number to remove: ");
        String roll = sc.next();
        for (Student s : students) {
            if (s.rollNo.equalsIgnoreCase(roll)) {
                students.remove(s);
                System.out.println("🗑️ Student removed.");
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }

    private static void searchStudent() {
        System.out.print("Enter roll number to search: ");
        String roll = sc.next();
        for (Student s : students) {
            if (s.rollNo.equalsIgnoreCase(roll)) {
                System.out.println("🎯 Student found:\n" + s);
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }

    private static void displayAll() {
        if (students.isEmpty()) System.out.println("No students available.");
        else {
            System.out.println("\n=== Student List ===");
            for (Student s : students) System.out.println(s);
        }
    }
}

