import java.util.Scanner;
public class Handshakecalculator {
    // Method to calculate the maximum number of handshakes
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2; // Combination formula
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// Taking input for the number of students
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
// Calculate the maximum number of handshakes
        int handshakes = calculateHandshakes(n);
// Output the result
        System.out.println("The maximum number of handshakes among " + n + " students is: " + handshakes);
    }
}