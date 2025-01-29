import java.util.Scanner;

public class SubstringOccurrence {
    public static int countSubstringOccurrences(String input, String substring) {
        int count = 0, index = 0;

        // Count occurrences of the substring
        while ((index = input.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the main string and substring
        System.out.print("Enter the main string: ");
        String input = scanner.nextLine();
        System.out.print("Enter the substring to count: ");
        String substring = scanner.nextLine();

        // Handle empty substring edge case
        if (substring.isEmpty()) {
            System.out.println("The substring cannot be empty.");
        } else {
            int occurrences = countSubstringOccurrences(input, substring);
            System.out.println("The substring '" + substring + "' occurs " + occurrences + " time(s) in the main string.");
        }

        scanner.close();
    }
}



