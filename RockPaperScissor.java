package InternshipProjects;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] options = {"rock", "paper", "scissors"};

        while (true) {
            System.out.println("Enter rock, paper, or scissors (or type 'exit' to quit):");
            String userChoice = scanner.next().toLowerCase();

            if (userChoice.equals("exit")) {
                System.out.println("Game over.");
                break;
            }

            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }

            String computerChoice = options[random.nextInt(3)];
            System.out.println("Computer chose: " + computerChoice);

            if (userChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                    (userChoice.equals("scissors") && computerChoice.equals("paper")) ||
                    (userChoice.equals("paper") && computerChoice.equals("rock"))) {
                System.out.println("You win!");
            } else {
                System.out.println("You lose!");
            }
        }

        scanner.close();
    }
}
