import java.util.regex.*;

public class LicensePlateValidator {
    public static boolean isValidLicensePlate(String plate) {
        // Define the regex pattern
        String regex = "^[A-Z]{2}\\d{4}$";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        // Match the input plate number with the pattern
        Matcher matcher = pattern.matcher(plate);

        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test cases
        String[] plates = {"AB1234", "A12345", "ABC123", "XY9876", "AB12", "ZP0000"};

        for (String plate : plates) {
            System.out.println(plate + " → " + (isValidLicensePlate(plate) ? "Valid" : "Invalid"));
        }
    }
}
