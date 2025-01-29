import java.util.Scanner;

public class ReverseString {
    public static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();

        // Reverse the string and display the result
        String reversedString = reverseString(input);
        System.out.println("Reversed string: " + reversedString);

        scanner.close();
    }
}



