import java.util.Scanner;

public class ChocolateDistribution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input number of chocolates and number of children
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();
        System.out.print("Enter the number of children: ");
        int numberOfChildren = scanner.nextInt();
        // Calculate chocolates each child gets and remaining chocolates
        int chocolatesPerChild = numberOfChocolates / numberOfChildren;
        int remainingChocolates = numberOfChocolates % numberOfChildren;
        // Output
        System.out.println("Each child gets " + chocolatesPerChild + " chocolates.");
        System.out.println("The remaining chocolates are " + remainingChocolates + ".");

    }
}
