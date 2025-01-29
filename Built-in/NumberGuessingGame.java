import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void playGame() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int low = 1, high = 100;
        boolean correct = false;

        System.out.println("Think of a number between 1 and 100.");

        while (!correct) {
            int guess = random.nextInt(high - low + 1) + low;
            System.out.println("Computer guesses: " + guess);
            System.out.print("Is it (H)igh, (L)ow, or (C)orrect? ");
            String feedback = scanner.nextLine().trim().toUpperCase();

            switch (feedback) {
                case "H":
                    high = guess - 1;
                    break;
                case "L":
                    low = guess + 1;
                    break;
                case "C":
                    System.out.println("Computer guessed the correct number!");
                    correct = true;
                    break;
                default:
                    System.out.println("Invalid input. Please enter H, L, or C.");
                    break;
            }
        }
    }
}