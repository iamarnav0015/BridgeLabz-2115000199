package Strings;

//Write a Java program to count how many times a given substring occurs in a
public class SubstringOccurrence {
    public static int countSubstringOccurrences(String input, String substring) {
        int count = 0, index = 0;
        while ((index = input.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }
}


