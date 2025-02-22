import java.util.regex.*;

public class CensorBadWords {
    public static String censorText(String text, String[] badWords) {
        // Loop through each bad word and replace it with ****
        for (String word : badWords) {
            String regex = "\\b" + word + "\\b"; // Ensure whole word match
            text = text.replaceAll("(?i)" + regex, "****"); // Case-insensitive replacement
        }
        return text;
    }

    public static void main(String[] args) {
        // Example input
        String input = "This is a damn bad example with some stupid words.";

        // List of bad words to censor
        String[] badWords = {"damn", "stupid"};

        // Process the text
        String output = censorText(input, badWords);

        // Print the result
        System.out.println("Original: " + input);
        System.out.println("Censored: " + output);
    }
}
