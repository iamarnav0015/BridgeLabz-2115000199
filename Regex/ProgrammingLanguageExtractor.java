import java.util.regex.*;
import java.util.*;

public class ProgrammingLanguageExtractor {
    public static List<String> extractLanguages(String text) {
        // List of common programming languages (customizable)
        String[] languages = {"Java", "Python", "JavaScript", "Go", "C", "C++", "C#", "Ruby", "Swift", "Kotlin", "PHP", "Rust", "Perl", "TypeScript"};

        // Create a regex pattern to match programming language names
        String regex = "\\b(" + String.join("|", languages) + ")\\b";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // List to store extracted languages
        List<String> extractedLanguages = new ArrayList<>();

        // Find and add matches to the list
        while (matcher.find()) {
            extractedLanguages.add(matcher.group());
        }

        return extractedLanguages;
    }

    public static void main(String[] args) {
        // Example text
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        // Extract and print programming languages
        List<String> languages = extractLanguages(text);
        System.out.println("Extracted Languages: " + String.join(", ", languages));
    }
}
