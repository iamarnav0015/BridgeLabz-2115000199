import java.util.regex.*;
import java.util.*;

public class CapitalizedWordExtractor {
    public static List<String> extractCapitalizedWords(String text) {
        // Define the regex pattern for capitalized words
        String regex = "\\b[A-Z][a-z]*\\b";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(text);

        // List to store extracted words
        List<String> capitalizedWords = new ArrayList<>();

        // Find and add all matches to the list
        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }

        return capitalizedWords;
    }

    public static void main(String[] args) {
        // Example text
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        // Extract and print capitalized words
        List<String> words = extractCapitalizedWords(text);
        System.out.println(words);
    }
}
