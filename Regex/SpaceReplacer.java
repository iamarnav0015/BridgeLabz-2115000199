public class SpaceReplacer {
    public static String replaceMultipleSpaces(String text) {
        // Use regex to replace multiple spaces with a single space
        return text.replaceAll("\\s+", " ").trim();
    }

    public static void main(String[] args) {
        // Example input with multiple spaces
        String input = "This  is   an   example    with multiple   spaces.";

        // Process the text
        String output = replaceMultipleSpaces(input);

        // Print the result
        System.out.println("Original: " + input);
        System.out.println("Modified: " + output);
    }
}
