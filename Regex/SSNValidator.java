import java.util.regex.*;

public class SSNValidator {
    public static boolean isValidSSN(String ssn) {
        // Regular expression for SSN (Format: XXX-XX-XXXX)
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ssn);

        // Return whether the SSN is valid
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Example test cases
        String[] ssns = {
                "123-45-6789", // Valid
                "987-65-4321", // Valid
                "123456789",   // Invalid (Missing dashes)
                "12-345-6789", // Invalid (Incorrect format)
                "123-456-789", // Invalid (Incorrect grouping)
                "abc-de-ghij"  // Invalid (Not numbers)
        };

        for (String ssn : ssns) {
            System.out.println(ssn + " → " + (isValidSSN(ssn) ? "Valid" : "Invalid"));
        }
    }
}
