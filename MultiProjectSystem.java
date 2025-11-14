package codsoft;

import java.util.*;

//==================================== MAIN CLASS ====================================
public class MultiProjectSystem {

 static Scanner sc = new Scanner(System.in);

 public static void main(String[] args) {
     while (true) {
         System.out.println("\n==============================");
         System.out.println("🎓 MULTI-PROJECT JAVA SYSTEM");
         System.out.println("==============================");
         System.out.println("1. Number Guessing Game");
         System.out.println("2. Student Grade Calculator");
         System.out.println("3. ATM Interface");
         System.out.println("4. Currency Converter");
         System.out.println("5. Student Management System");
         System.out.println("6. Exit");
         System.out.println("==============================");
         System.out.print("Enter your choice: ");

         int choice = getIntInput();

         switch (choice) {
             case 1 -> numberGame();
             case 2 -> gradeCalculator();
             case 3 -> atmInterface();
             case 4 -> currencyConverter();
             case 5 -> studentManagementSystem();
             case 6 -> {
                 System.out.println("👋 Thank you for using the Multi-Project System!");
                 System.exit(0);
             }
             default -> System.out.println("⚠️ Invalid choice! Try again.");
         }
     }
 }

 // Safe integer input
 private static int getIntInput() {
     while (!sc.hasNextInt()) {
         System.out.print("⚠️ Please enter a valid number: ");
         sc.next();
     }
     return sc.nextInt();
 }

 // Safe double input
 private static double getDoubleInput() {
     while (!sc.hasNextDouble()) {
         System.out.print("⚠️ Please enter a valid number: ");
         sc.next();
     }
     return sc.nextDouble();
 }

 // ==================================== TASK 1: Number Game ====================================
 public static void numberGame() {
     System.out.println("\n🎯 Welcome to the Number Guessing Game!");
     Random random = new Random();
     int score = 0;
     String playAgain = "yes";
     sc.nextLine(); // clear buffer

     while (playAgain.equalsIgnoreCase("yes")) {
         int number = random.nextInt(100) + 1;
         int attempts = 0, maxAttempts = 7;

         System.out.println("\nI'm thinking of a number between 1 and 100.");
         while (attempts < maxAttempts) {
             System.out.print("Enter your guess: ");
             int guess = getIntInput();
             attempts++;

             if (guess == number) {
                 System.out.println("🎉 Correct! You guessed it in " + attempts + " attempts.");
                 score++;
                 break;
             } else if (guess < number)
                 System.out.println("Too low! Try again.");
             else
                 System.out.println("Too high! Try again.");
         }

         if (attempts == maxAttempts)
             System.out.println("❌ You've run out of attempts! The number was " + number);

         System.out.print("Play again? (yes/no): ");
         playAgain = sc.next();
     }

     System.out.println("\nYour final score: " + score);
     System.out.println("Thanks for playing!");
 }

 // ==================================== TASK 2: Grade Calculator ====================================
 public static void gradeCalculator() {
     System.out.println("\n📘 Student Grade Calculator");
     System.out.print("Enter number of subjects: ");
     int subjects = getIntInput();

     double total = 0;
     for (int i = 1; i <= subjects; i++) {
         System.out.print("Enter marks for subject " + i + " (out of 100): ");
         double marks = getDoubleInput();
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
 }

 // ==================================== TASK 3: ATM Interface ====================================
 public static void atmInterface() {
     BankAccount account = new BankAccount(1000);
     ATM atm = new ATM(account);
     atm.menu();
 }

 static class BankAccount {
     private double balance;

     public BankAccount(double balance) {
         this.balance = balance;
     }

     public void deposit(double amount) {
         balance += amount;
         System.out.println("Deposited ₹" + amount + ". New balance: ₹" + balance);
     }

     public void withdraw(double amount) {
         if (amount > balance)
             System.out.println("❌ Insufficient balance!");
         else {
             balance -= amount;
             System.out.println("Withdrew ₹" + amount + ". Remaining balance: ₹" + balance);
         }
     }

     public void checkBalance() {
         System.out.println("💰 Current balance: ₹" + balance);
     }
 }

 static class ATM {
     private final BankAccount account;

     public ATM(BankAccount account) {
         this.account = account;
     }

     public void menu() {
         while (true) {
             System.out.println("\n=== ATM MENU ===");
             System.out.println("1. Check Balance");
             System.out.println("2. Deposit Money");
             System.out.println("3. Withdraw Money");
             System.out.println("4. Exit");
             System.out.print("Enter your choice: ");

             int choice = getIntInput();

             switch (choice) {
                 case 1 -> account.checkBalance();
                 case 2 -> {
                     System.out.print("Enter amount to deposit: ");
                     double d = getDoubleInput();
                     account.deposit(d);
                 }
                 case 3 -> {
                     System.out.print("Enter amount to withdraw: ");
                     double w = getDoubleInput();
                     account.withdraw(w);
                 }
                 case 4 -> {
                     System.out.println("🏧 Thank you for using our ATM!");
                     return;
                 }
                 default -> System.out.println("Invalid choice! Try again.");
             }
         }
     }
 }

 // ==================================== TASK 4: Currency Converter ====================================
 public static void currencyConverter() {
     System.out.println("\n🌍 Currency Converter");

     System.out.print("Enter base currency (e.g., USD, INR): ");
     String base = sc.next().toUpperCase();

     System.out.print("Enter target currency: ");
     String target = sc.next().toUpperCase();

     System.out.print("Enter amount to convert: ");
     double amount = getDoubleInput();

     // Static exchange rates (for offline demo)
     Map<String, Double> rates = new HashMap<>();
     rates.put("USDINR", 83.2);
     rates.put("INRUSD", 0.012);
     rates.put("USDEUR", 0.93);
     rates.put("EURUSD", 1.08);
     rates.put("INREUR", 0.011);
     rates.put("EURINR", 90.0);

     String key = base + target;
     if (rates.containsKey(key)) {
         double converted = amount * rates.get(key);
         System.out.println("\n💵 " + amount + " " + base + " = " + converted + " " + target);
     } else {
         System.out.println("⚠️ Conversion rate not available for " + base + " to " + target);
     }
 }

 // ==================================== TASK 5: Student Management System ====================================
 public static void studentManagementSystem() {
     StudentManagementSystem sms = new StudentManagementSystem();
     sms.menu();
 }

 static class Student {
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

 static class StudentManagementSystem {
     List<Student> students = new ArrayList<>();

     void addStudent() {
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

     void removeStudent() {
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

     void searchStudent() {
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

     void displayAll() {
         if (students.isEmpty()) System.out.println("No students available.");
         else {
             System.out.println("\n=== Student List ===");
             for (Student s : students) System.out.println(s);
         }
     }

     void menu() {
         while (true) {
             System.out.println("\n=== Student Management System ===");
             System.out.println("1. Add Student");
             System.out.println("2. Remove Student");
             System.out.println("3. Search Student");
             System.out.println("4. Display All Students");
             System.out.println("5. Exit");
             System.out.print("Enter your choice: ");

             int choice = getIntInput();
             switch (choice) {
                 case 1 -> addStudent();
                 case 2 -> removeStudent();
                 case 3 -> searchStudent();
                 case 4 -> displayAll();
                 case 5 -> {
                     System.out.println("👋 Exiting Student Management System.");
                     return;
                 }
                 default -> System.out.println("Invalid choice! Try again.");
             }
         }
     }
 }
}
