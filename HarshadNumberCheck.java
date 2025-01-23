import java.util.Scanner;

public class HarshadNumberCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to check if it is a Harshad number: ");
        int number = scanner.nextInt();
        int originalNumber = number;
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        if (originalNumber % sum == 0) {
            System.out.println(originalNumber + " is a Harshad number.");
        } else {
            System.out.println(originalNumber + " is not a Harshad number.");
        }
    }
}
