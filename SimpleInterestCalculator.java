import java.util.Scanner;

public class SimpleInterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input Principal, Rate, and Time
        System.out.print("Enter the Principal amount: ");
        double principal = scanner.nextDouble();
        System.out.print("Enter the Rate of Interest: ");
        double rate = scanner.nextDouble();
        System.out.print("Enter the Time period (in years): ");
        double time = scanner.nextDouble();
        // Calculate Simple Interest
        double simpleInterest = (principal * rate * time) / 100;
        // Output result
        System.out.printf("The Simple Interest is %.2f for Principal %.2f, Rate of Interest %.2f and Time %.2f years.\n", simpleInterest, principal, rate, time);
    }
}
