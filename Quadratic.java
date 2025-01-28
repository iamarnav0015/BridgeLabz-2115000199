
import java.util.Scanner;

public class Quadratic {

    public static double[] findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c; // Calculate delta (b^2 - 4ac)
        double[] roots = new double[2];

        if (delta > 0) {
            // Two real roots
            roots[0] = (-b + Math.sqrt(delta)) / (2 * a); // root1
            roots[1] = (-b - Math.sqrt(delta)) / (2 * a); // root2
        } else if (delta == 0) {
            // One real root
            roots = new double[]{-b / (2 * a)}; // Single root
        } else {
            // No real roots, return an empty array or nothing
            roots = new double[0];
        }

        return roots;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();

        double[] roots = findRoots(a, b, c);

        if (roots.length == 2) {
            System.out.println("The roots are: " + roots[0] + " and " + roots[1]);
        } else if (roots.length == 1) {
            System.out.println("The root is: " + roots[0]);
        } else {
            System.out.println("No real roots.");
        }
    }
}

