import java.util.regex.*;

public class HexColorValidator {
    public static boolean isValidHexColor(String color) {
        // Define the regex pattern
        String regex = "^#([a-fA-F0-9]{6})$";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        // Match the input color with the pattern
        Matcher matcher = pattern.matcher(color);

        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test cases
        String[] colors = {"#FFA500", "#ff4500", "#123", "#ABCDEF", "#a1b2c3", "#GGGGGG"};

        for (String color : colors) {
            System.out.println(color + " → " + (isValidHexColor(color) ? "Valid" : "Invalid"));
        }
    }
}
