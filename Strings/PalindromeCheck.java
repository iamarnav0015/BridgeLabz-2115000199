import java.util.Scanner;

public class PalindromeCheck {
    public static boolean isPalindrome(String input) {
        input = input.replaceAll("\\s+", "").toLowerCase();
        int left = 0, right = input.length() - 1;
        while(left < right) {
            if(input.charAt(left) != input.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check if it's a palindrome: ");
        String input = scanner.nextLine();
        System.out.println(isPalindrome(input) ? "The string is a palindrome." : "The string is not a palindrome.");
    }
}
