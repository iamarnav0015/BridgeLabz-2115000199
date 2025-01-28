
import java.util.Scanner;

public class NumberChecker {

    public static String isPositive(int number) {
        return number >= 0 ? "Positive" : "Negative";
    }

    public static String isEven(int number) {
        return number % 2 == 0 ? "Even" : "Odd";
    }

    public static int compare(int num1, int num2) {
        if (num1 > num2) return 1;
        else if (num1 == num2) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        // Taking user input for 5 numbers
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Checking each number and printing positive/negative and even/odd
        for (int num : numbers) {
            String positivity = isPositive(num);
            System.out.println(num + " is " + positivity);
            if (positivity.equals("Positive")) {
                System.out.println(num + " is " + isEven(num));
            }
        }

        // Comparing the first and last elements
        int comparisonResult = compare(numbers[0], numbers[4]);
        if (comparisonResult == 1) {
            System.out.println("First number is greater than last number.");
        } else if (comparisonResult == 0) {
            System.out.println("First number is equal to last number.");
        } else {
            System.out.println("First number is less than last number.");
        }

        scanner.close();
    }
}

