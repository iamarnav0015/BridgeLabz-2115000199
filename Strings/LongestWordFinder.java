import java.util.Scanner;

public class LongestWordFinder {
    public static String findLongestWord(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return "No valid words found.";
        }

        String[] words = sentence.split("\\s+");
        String longestWord = "";

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return longestWord;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        // Find and display the longest word
        String longestWord = findLongestWord(sentence);
        if (!longestWord.equals("No valid words found.")) {
            System.out.println("The longest word is: '" + longestWord + "'");
        } else {
            System.out.println(longestWord);
        }

        scanner.close();
    }
}



