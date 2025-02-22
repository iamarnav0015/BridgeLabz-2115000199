import java.util.regex.*;

public class CreditCardValidator {
    public static boolean isValidCreditCard(String cardNumber) {
        // Regular expressions for Visa and MasterCard
        String visaRegex = "^4\\d{15}$";  // Visa: Starts with 4, 16 digits
        String masterCardRegex = "^5\\d{15}$";  // MasterCard: Starts with 5, 16 digits

        // Compile the patterns
        Pattern visaPattern = Pattern.compile(visaRegex);
        Pattern masterCardPattern = Pattern.compile(masterCardRegex);

        // Match the input card number with both patterns
        return visaPattern.matcher(cardNumber).matches() || masterCardPattern.matcher(cardNumber).matches();
    }

    public static void main(String[] args) {
        // Example test cases
        String[] cardNumbers = {
                "4111111111111111", // Valid Visa
                "5111111111111111", // Valid MasterCard
                "6111111111111111", // Invalid (Does not start with 4 or 5)
                "4222222222222",    // Invalid (Not 16 digits)
                "5000111122223333", // Valid MasterCard
                "4000111122223333"  // Valid Visa
        };

        for (String card : cardNumbers) {
            System.out.println(card + " → " + (isValidCreditCard(card) ? "Valid" : "Invalid"));
        }
    }
}
