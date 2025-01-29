import java.util.Scanner;

public class AnagramCheck {
    public static String replaceWord(String sentence, String target, String replacement) {
        return sentence.replace(target, replacement);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for sentence, target, and replacement
        System.out.print("Enter the sentence: ");
        String sentence = scanner.nextLine();
        System.out.print("Enter the target word to replace: ");
        String target = scanner.next();
        System.out.print("Enter the replacement word: ");
        String replacement = scanner.next();

        // Perform word replacement
        if (sentence.contains(target)) {
            String modifiedSentence = replaceWord(sentence, target, replacement);
            System.out.println("Original Sentence: " + sentence);
            System.out.println("Modified Sentence: " + modifiedSentence);
        } else {
            System.out.println("The target word '" + target + "' was not found in the sentence.");
        }
    }
}

