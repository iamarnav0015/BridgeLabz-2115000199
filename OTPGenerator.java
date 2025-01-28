
import java.util.HashSet;
import java.util.Set;

public class OTPGenerator {

    // Method to generate a 6-digit OTP number using Math.random()
    public static int generateOTP() {
        return (int) (Math.random() * 900000) + 100000;  // Generate a random number between 100000 and 999999
    }

    // Method to check if all generated OTP numbers are unique
    public static boolean areOTPsUnique(int[] otps) {
        Set<Integer> otpSet = new HashSet<>();
        for (int otp : otps) {
            if (!otpSet.add(otp)) {
                return false; // If adding the OTP fails, it means it's a duplicate
            }
        }
        return true; // All OTPs are unique
    }

    public static void main(String[] args) {
        int[] otps = new int[10];

        // Generate 10 OTPs and store them in the array
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
        }

        // Display the generated OTPs
        System.out.println("Generated OTPs: ");
        for (int otp : otps) {
            System.out.println(otp);
        }

        // Check if the OTPs are unique
        boolean isUnique = areOTPsUnique(otps);
        if (isUnique) {
            System.out.println("All OTPs are unique.");
        } else {
            System.out.println("Some OTPs are duplicates.");
        }
    }
}

