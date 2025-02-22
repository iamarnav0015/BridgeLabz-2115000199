import java.util.regex.*;
import java.util.*;

public class RepeatingWordFinder {
    public static Set<String> findRepeatingWords(String text) {
        // Regex pattern to match repeating words
        String regex = "\\b(\\w+)\\b(?:\\s+\\1\\b)";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        // Set to store unique repeating words
        Set<String> repeatingWords = new HashSet<>();

        // Find and add repeating words to the set
        while (matcher.find()) {
            repeatingWords.add(matcher.group(1)); // Capture the repeating word
        }

        return repeatingWords;
    }

    public static void main(String[] args) {
        // Example input
        String text = "This is is a repeated repeated word test.";

        // Extract and print repeating words
        Set<String> words = findRepeatingWords(text);
        System.out.println("Repeating Words: " + String.join(", ", words));
    }
}
