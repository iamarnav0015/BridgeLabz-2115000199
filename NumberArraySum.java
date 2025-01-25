import java.util.Scanner;
public class NumberArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        System.out.println("Enter numbers (0 or negative number to stop, max 10 numbers):");
        while (true) {
            double input = scanner.nextDouble();
            if (input <= 0) {
                break;
            }
            if (index == 10) {
                System.out.println("Maximum limit of 10 numbers reached.");
                break;
            }
            numbers[index] = input;
            index++;
        }
        System.out.println("You entered:");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
            total += numbers[i];
        }
        System.out.println("\nTotal sum of numbers: " + total);
    }
}
