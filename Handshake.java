import java.util.Scanner;
public class Handshake {
    public static void main(String[] args) {
        int numberOfStudents;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        numberOfStudents = input.nextInt();
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
        System.out.println("The maximum number of possible handshakes is " + handshakes);
    }
}