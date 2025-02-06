import java.util.Scanner;

public class DoubleOpt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input values for a, b, and c as doubles
        System.out.print("Enter the value of a (double): ");
        double a = scanner.nextDouble();
        System.out.print("Enter the value of b (double): ");
        double b = scanner.nextDouble();
        System.out.print("Enter the value of c (double): ");
        double c = scanner.nextDouble();
        // Perform double operations
        double result1 = a + b * c;
        double result2 = a * b + c;
        double result3 = c + a / b;
        double result4 = a % b + c;
        // Output
        System.out.println("The results of Double Operations are:");
        System.out.println("a + b * c = " + result1);
        System.out.println("a * b + c = " + result2);
        System.out.println("c + a / b = " + result3);
        System.out.println("a % b + c = " + result4);
    }
}
