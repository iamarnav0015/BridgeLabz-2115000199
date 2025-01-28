import java.util.Scanner;

public class MaximumHandshakes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// Get input for the number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
// Calculate the maximum number of handshakes using the combination formula
        int maxHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
// Display the result
        System.out.println("The maximum number of handshakes among " +
                numberOfStudents + " students is: " + maxHandshakes);
    }
}
