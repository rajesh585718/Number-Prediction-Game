package com.internship.numberprediction;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Game class handles the logic for the number prediction game.
 */
public class Game {
    private final Scanner scanner;
    private final Random random;

    public Game() {
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public void start() {
        System.out.println("\n=== Number Prediction Game ===\n");
        boolean keepPlaying = true;
        while (keepPlaying) {
            showMenu();
            int choice = readInt("Choose option: ");
            switch (choice) {
                case 1 -> play();
                case 2 -> showInstructions();
                case 3 -> {
                    System.out.println("Thanks for playing! Goodbye.");
                    keepPlaying = false;
                }
                default -> System.out.println("Invalid option. Please enter 1, 2 or 3.");
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu:");
        System.out.println("  1) Play game");
        System.out.println("  2) Instructions");
        System.out.println("  3) Exit");
    }

    private void showInstructions() {
        System.out.println("\nInstructions:");
        System.out.println(" - Choose a difficulty which sets the range and allowed attempts.");
        System.out.println(" - A secret number will be generated within that range.");
        System.out.println(" - Try to predict (guess) the number within the allowed attempts.");
        System.out.println(" - After each guess you will be told whether the secret number is higher or lower.");
        System.out.println(" - Score is based on remaining attempts and difficulty.\n");
    }

    private void play() {
        System.out.println("\nSelect difficulty:");
        System.out.println("  1) Easy   (range: 1-10, attempts: 5)");
        System.out.println("  2) Medium (range: 1-50, attempts: 7)");
        System.out.println("  3) Hard   (range: 1-100, attempts: 10)");
        int diff = 0;
        while (diff < 1 || diff > 3) {
            diff = readInt("Choose difficulty (1-3): ");
            if (diff < 1 || diff > 3) System.out.println("Please select 1, 2 or 3.");
        }

        int max = 10;
        int attempts = 5;
        int baseScore = 50;
        if (diff == 2) { max = 50; attempts = 7; baseScore = 120; }
        if (diff == 3) { max = 100; attempts = 10; baseScore = 300; }

        int secret = random.nextInt(max) + 1; // 1..max
        int remaining = attempts;
        boolean won = false;

        System.out.printf("\nI'm thinking of a number between 1 and %d. You have %d attempts. Good luck!\n", max, attempts);

        while (remaining > 0 && !won) {
            int guess = readInt("Enter your guess: ");
            if (guess < 1 || guess > max) {
                System.out.println("Guess out of range — try a number within the range.");
                continue;
            }
            remaining--;
            if (guess == secret) {
                won = true;
                int score = calculateScore(baseScore, remaining, diff);
                System.out.printf("Correct! The number was %d. You scored: %d points.\n", secret, score);
            } else if (guess < secret) {
                System.out.println("Too low.");
                System.out.printf("Attempts left: %d\n", remaining);
            } else {
                System.out.println("Too high.");
                System.out.printf("Attempts left: %d\n", remaining);
            }
        }

        if (!won) {
            System.out.printf("\nYou've used all attempts. The secret number was %d. Better luck next time!\n", secret);
        }

        System.out.println();
    }

    private int calculateScore(int base, int remainingAttempts, int difficulty) {
        // Simple score formula: base + remainingAttempts * multiplier - difficulty penalty
        int multiplier = 10;
        int difficultyPenalty = (difficulty - 1) * 20;
        return Math.max(0, base + remainingAttempts * multiplier - difficultyPenalty);
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int n = scanner.nextInt();
                scanner.nextLine(); // consume newline
                return n;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // discard invalid input
            }
        }
    }
}
