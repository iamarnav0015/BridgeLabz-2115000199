import java.util.regex.*;
import java.util.*;

public class EmailExtractor {
    public static List<String> extractEmails(String text) {
        // Define the regex pattern for email extraction
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(text);

        // List to store extracted emails
        List<String> emails = new ArrayList<>();

        // Find and add all matches to the list
        while (matcher.find()) {
            emails.add(matcher.group());
        }

        return emails;
    }

    public static void main(String[] args) {
        // Example text
        String text = "Contact us at support@example.com and info@company.org for more details.";

        // Extract and print emails
        List<String> emails = extractEmails(text);
        for (String email : emails) {
            System.out.println(email);
        }
    }
}
