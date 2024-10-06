package InternshipProjects;

import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1;
        int guess;
        int attempts = 0;

        System.out.print("Guess a number between 1 and 100: ");

        while (true) {
            guess = scanner.nextInt();
            attempts++;

            if (guess > targetNumber) {
                System.out.print("Too high! Try again: ");
            } else if (guess < targetNumber) {
                System.out.print("Too low! Try again: ");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                break;
            }
        }

        scanner.close();
    }
}