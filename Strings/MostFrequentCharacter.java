package Strings;

import java.util.HashMap;
public class MostFrequentCharacter {
    public static char findMostFrequentCharacter(String input) {
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
}

