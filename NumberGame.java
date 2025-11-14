package codsoft;

import java.util.*;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        String playAgain = "yes";

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        while (playAgain.equalsIgnoreCase("yes")) {
            int number = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;

            System.out.println("\nI'm thinking of a number between 1 and 100.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("🎉 Correct! You guessed it in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (guess < number) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (attempts == maxAttempts)
                System.out.println("❌ You've run out of attempts! The number was " + number);

            System.out.print("Play again? (yes/no): ");
            playAgain = sc.next();
        }

        System.out.println("\nYour final score: " + score);
        System.out.println("Thanks for playing!");
        sc.close();
    }
}

