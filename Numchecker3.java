
import java.util.Scanner;

public class Numchecker3 {

    // Method to find the count of digits in the number
    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    // Method to store the digits of the number in an array
    public static int[] storeDigits(int number) {
        int digitCount = countDigits(number);
        int[] digits = new int[digitCount];
        for (int i = digitCount - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    // Method to find the sum of the digits of the number
    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    // Method to find the sum of the squares of the digits
    public static double sumOfSquaresOfDigits(int[] digits) {
        double sumOfSquares = 0;
        for (int digit : digits) {
            sumOfSquares += Math.pow(digit, 2);
        }
        return sumOfSquares;
    }

    // Method to check if a number is a Harshad number
    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    // Method to find the frequency of each digit in the number
    public static int[][] findFrequency(int[] digits) {
        int[][] frequency = new int[10][2]; // 10 digits, each with digit and frequency
        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i; // First column stores the digit
        }

        for (int digit : digits) {
            frequency[digit][1]++; // Second column stores the frequency of the digit
        }

        return frequency;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int[] digits = storeDigits(number);

        System.out.println("Count of digits: " + countDigits(number));

        System.out.println("Sum of digits: " + sumOfDigits(digits));

        System.out.println("Sum of squares of digits: " + sumOfSquaresOfDigits(digits));

        System.out.println("Is the number a Harshad number? " + isHarshadNumber(number, digits));

        System.out.println("Digit frequencies:");
        int[][] frequencies = findFrequency(digits);
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i][1] > 0) { // Only print digits that appear
                System.out.println(frequencies[i][0] + " appears " + frequencies[i][1] + " times");
            }
        }
    }
}



