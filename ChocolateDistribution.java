import java.util.Scanner;
public class ChocolateDistribution {
    // Method to find the chocolates each child gets and the remaining chocolates
    public static int[] findRemainderAndQuotient(int numberOfChocolates, int
            numberOfChildren) {
        int chocolatesPerChild = numberOfChocolates / numberOfChildren; //Chocolates each child gets
        int remainingChocolates = numberOfChocolates % numberOfChildren; //Remaining chocolates
        return new int[]{chocolatesPerChild, remainingChocolates}; // Return both asan array
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// Get input for number of chocolates and number of children
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();
        System.out.print("Enter the number of children: ");
        int numberOfChildren = scanner.nextInt();
// Call the method to find chocolates per child and remaining chocolates
        int[] result = findRemainderAndQuotient(numberOfChocolates,
                numberOfChildren);
// Display the results
        System.out.println("Each child will get " + result[0] + " chocolates.");
        System.out.println("Remaining chocolates: " + result[1]);
    }
}