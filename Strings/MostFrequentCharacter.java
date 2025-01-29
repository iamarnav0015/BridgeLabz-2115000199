import java.util.HashMap;
import java.util.Scanner;

public class MostFrequentCharacter {
    public static char findMostFrequentCharacter(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be empty.");
        }

        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        char mostFrequent = input.charAt(0);
        int maxCount = 0;
        for (char c : frequencyMap.keySet()) {
            if (frequencyMap.get(c) > maxCount) {
                mostFrequent = c;
                maxCount = frequencyMap.get(c);
            }
        }
        return mostFrequent;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        try {
            char result = findMostFrequentCharacter(input);
            System.out.println("The most frequent character is: '" + result + "'");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}



