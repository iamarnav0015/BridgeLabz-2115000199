import java.util.Scanner;

public class QuotientAndReminder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input numbers
        System.out.print("Enter the first number: ");
        int number1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int number2 = scanner.nextInt();
        // Calculate quotient and remainder
        int quotient = number1 / number2;
        int remainder = number1 % number2;
        // Output result
        System.out.println("The Quotient is " + quotient + " and Reminder is " + remainder + " of two numbers " + number1 + " and " + number2);

    }
}
