import java.util.regex.*;
import java.util.*;

public class LinkExtractor {
    public static List<String> extractLinks(String text) {
        // Define the regex pattern for URLs (HTTP/HTTPS)
        String regex = "\\bhttps?://[\\w\\.-]+(?:\\.[\\w\\.-]+)+\\S*\\b";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(text);

        // List to store extracted links
        List<String> links = new ArrayList<>();

        // Find and add all matches to the list
        while (matcher.find()) {
            links.add(matcher.group());
        }

        return links;
    }

    public static void main(String[] args) {
        // Example text containing links
        String text = "Visit https://www.google.com and http://example.org for more info.";

        // Extract and print links
        List<String> links = extractLinks(text);
        for (String link : links) {
            System.out.println(link);
        }
    }
}
