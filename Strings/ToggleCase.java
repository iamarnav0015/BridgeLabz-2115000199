import java.util.Scanner;

public class ToggleCase {
    public static String toggleCase(String input) {
        StringBuilder toggled = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                toggled.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                toggled.append(Character.toUpperCase(c));
            } else {
                toggled.append(c);
            }
        }
        return toggled.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a string to toggle case: ");
        String input = scanner.nextLine();

        // Toggle case and display result
        String result = toggleCase(input);
        System.out.println("Toggled Case: " + result);

        scanner.close();
    }
}



