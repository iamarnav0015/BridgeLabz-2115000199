
import java.util.Scanner;

public class Numchecker4 {

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    // Method to check if a number is a neon number
    public static boolean isNeonNumber(int number) {
        int square = number * number;
        int sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == number;
    }

    // Method to check if a number is a spy number
    public static boolean isSpyNumber(int number) {
        int sum = 0;
        int product = 1;
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            product *= digit;
            number /= 10;
        }
        return sum == product;
    }

    // Method to check if a number is an automorphic number
    public static boolean isAutomorphic(int number) {
        int square = number * number;
        String strNumber = String.valueOf(number);
        String strSquare = String.valueOf(square);
        return strSquare.endsWith(strNumber);
    }

    // Method to check if a number is a buzz number
    public static boolean isBuzzNumber(int number) {
        return (number % 7 == 0 || number % 10 == 7);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        System.out.println("Is the number prime? " + isPrime(number));
        System.out.println("Is the number a neon number? " + isNeonNumber(number));
        System.out.println("Is the number a spy number? " + isSpyNumber(number));
        System.out.println("Is the number an automorphic number? " + isAutomorphic(number));
        System.out.println("Is the number a buzz number? " + isBuzzNumber(number));
    }}

