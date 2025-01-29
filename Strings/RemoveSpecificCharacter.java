package Strings;

public class RemoveSpecificCharacter {
    public static String removeCharacter(String input, char toRemove) {
        return input.replace(String.valueOf(toRemove), "");
    }
}

