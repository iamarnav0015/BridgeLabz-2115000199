import java.util.Scanner;
public class QuotientAndRemainder {
    // Method to find the quotient and remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor; // Calculate the quotient
        int remainder = number % divisor; // Calculate the remainder
        return new int[]{quotient, remainder}; // Return both as an array
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// Get input for two numbers from the user
        System.out.print("Enter the dividend (number): ");
        int number = scanner.nextInt();
        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();
// Call the method to find quotient and remainder
        int[] result = findRemainderAndQuotient(number, divisor);
// Display the results
        System.out.println("The quotient is: " + result[0]);
        System.out.println("The remainder is: " + result[1]);
    }
}