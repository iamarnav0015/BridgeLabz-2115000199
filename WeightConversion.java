import java.util.Scanner;

public class WeightConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input weight in pounds
        System.out.print("Enter the weight in pounds: ");
        double weightInPounds = scanner.nextDouble();
        // Convert pounds to kilograms
        double weightInKg = weightInPounds * 2.2;
        // Output
        System.out.printf("The weight of the person in pounds is %.2f and in kg is %.2f.\n", weightInPounds, weightInKg);

    }
}
