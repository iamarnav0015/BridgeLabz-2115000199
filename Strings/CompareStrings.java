import java.util.Scanner;

public class CompareStrings {
    public static void compareStrings(String str1, String str2) {
        int comparison = str1.compareTo(str2);
        if (comparison < 0) {
            System.out.println("'" + str1 + "' comes before '" + str2 + "' lexicographically.");
        } else if (comparison > 0) {
            System.out.println("'" + str2 + "' comes before '" + str1 + "' lexicographically.");
        } else {
            System.out.println("Both strings are equal.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();

        // Compare and display the result
        compareStrings(str1, str2);

        scanner.close();
    }
}



