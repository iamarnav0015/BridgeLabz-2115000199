import java.util.Scanner;

public class AthleteRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input sides
        System.out.print("Enter the length of side1 (in meters): ");
        double side1 = scanner.nextDouble();
        System.out.print("Enter the length of side2 (in meters): ");
        double side2 = scanner.nextDouble();
        System.out.print("Enter the length of side3 (in meters): ");
        double side3 = scanner.nextDouble();
        // Calculate the perimeter
        double perimeter = side1 + side2 + side3;
        // The total distance to run
        double totalDistance = 5000;
        // Calculate the number of rounds
        double rounds = totalDistance / perimeter;
        // Output
        System.out.printf("The total number of rounds the athlete will run is %.2f to complete 5 km.\n", rounds);
    }
}
