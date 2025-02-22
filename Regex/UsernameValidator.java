import java.util.regex.*;

public class UsernameValidator {
    public static boolean isValidUsername(String username) {
        // Define the regex pattern
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        // Match the input username with the pattern
        Matcher matcher = pattern.matcher(username);

        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test cases
        String[] usernames = {"user_123", "123user", "us", "ValidUser", "userName123_", "u_1234567890123"};

        for (String username : usernames) {
            System.out.println(username + " → " + (isValidUsername(username) ? "Valid" : "Invalid"));
        }
    }
}
