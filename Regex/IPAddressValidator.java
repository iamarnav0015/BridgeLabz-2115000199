import java.util.regex.*;

public class IPAddressValidator {
    public static boolean isValidIPAddress(String ip) {
        // Regular expression for a valid IPv4 address
        String regex =
                "^((25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\.){3}" +  // First three octets (0-255).
                        "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$";           // Last octet (0-255).

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        // Match the input IP address with the pattern
        Matcher matcher = pattern.matcher(ip);

        return matcher.matches();
    }

    public static void main(String[] args) {
        // Example test cases
        String[] ipAddresses = {
                "192.168.1.1",   // Valid
                "255.255.255.255", // Valid
                "256.100.50.25",  // Invalid (256 is out of range)
                "192.168.1",      // Invalid (missing last octet)
                "192.168.01.1",   // Valid (leading zeros allowed)
                "10.0.300.1",     // Invalid (300 out of range)
                "127.0.0.1"       // Valid (localhost)
        };

        for (String ip : ipAddresses) {
            System.out.println(ip + " → " + (isValidIPAddress(ip) ? "Valid" : "Invalid"));
        }
    }
}
