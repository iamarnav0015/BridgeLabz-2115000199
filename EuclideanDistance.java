import java.util.Scanner;

public class EuclideanDistance {

    // Method to calculate the Euclidean distance between two points (x1, y1) and (x2, y2)
    public static double calculateEuclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));  // Using Euclidean distance formula
    }

    // Method to find the equation of a line given two points and return the slope and y-intercept
    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double[] result = new double[2];  // Array to store slope (m) and y-intercept (b)

        // Calculate slope (m) using formula m = (y2 - y1) / (x2 - x1)
        double m = (y2 - y1) / (x2 - x1);

        // Calculate y-intercept (b) using formula b = y1 - m * x1
        double b = y1 - m * x1;

        result[0] = m;  // Slope
        result[1] = b;  // Y-intercept

        return result;  // Return array containing slope and y-intercept
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input points (x1, y1) and (x2, y2)
        System.out.print("Enter x1, y1: ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.print("Enter x2, y2: ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        // Calculate Euclidean distance
        double distance = calculateEuclideanDistance(x1, y1, x2, y2);
        System.out.println("Euclidean Distance: " + distance);

        // Find the equation of the line
        double[] lineEquation = findLineEquation(x1, y1, x2, y2);
        System.out.println("Equation of the line: y = " + lineEquation[0] + " * x + " + lineEquation[1]);
    }
}



