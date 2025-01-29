import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isPalindrome(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.println(input + (isPalindrome(input) ? " is a palindrome." : " is not a palindrome."));
    }
}

