package codsoft;

import java.util.*;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("📘 Student Grade Calculator");

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        double total = 0;
        for (int i = 1; i <= subjects; i++) {
            System.out.print("Enter marks for subject " + i + " (out of 100): ");
            double marks = sc.nextDouble();
            total += marks;
        }

        double avg = total / subjects;
        String grade;

        if (avg >= 90) grade = "A+";
        else if (avg >= 80) grade = "A";
        else if (avg >= 70) grade = "B";
        else if (avg >= 60) grade = "C";
        else if (avg >= 50) grade = "D";
        else grade = "F";

        System.out.println("\nTotal Marks: " + total);
        System.out.println("Average Percentage: " + avg + "%");
        System.out.println("Grade: " + grade);
        sc.close();
    }
}
