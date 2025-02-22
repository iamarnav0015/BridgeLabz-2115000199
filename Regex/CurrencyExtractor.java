import java.util.regex.*;
import java.util.*;

public class CurrencyExtractor {
    public static List<String> extractCurrencyValues(String text) {
        // Regex pattern to match currency values (e.g., "$45.99", "10.50")
        String regex = "\\$?\\d+(\\.\\d{2})?";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // List to store extracted values
        List<String> extractedValues = new ArrayList<>();

        // Find and add matches to the list
        while (matcher.find()) {
            extractedValues.add(matcher.group());
        }

        return extractedValues;
    }

    public static void main(String[] args) {
        // Example text
        String text = "The price is $45.99, and the discount is 10.50.";

        // Extract and print currency values
        List<String> values = extractCurrencyValues(text);
        System.out.println("Extracted Currency Values: " + String.join(", ", values));
    }
}
