public class SpringSeason {
    // Method to check if the date is in Spring Season
    public static boolean isSpringSeason(int month, int day) {
// Check for March
        if (month == 3 && day >= 20 && day <= 31) {
            return true;
        }
// Check for April
        else if (month == 4 && day >= 1 && day <= 30) {
            return true;

        }
// Check for May
        else if (month == 5 && day >= 1 && day <= 31) {
            return true;
        }
// Check for June
        else if (month == 6 && day >= 1 && day <= 20) {
            return true;
        }
// If the date doesn't fall in Spring Season
        return false;
    }
    public static void main(String[] args) {
// Ensure two command-line arguments are passed
        if (args.length != 2) {
            System.out.println("Please provide the month and day as command-line arguments.");
            return;
        }
// Parse month and day from command-line arguments
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);
// Check if it's Spring Season and print the result
        if (isSpringSeason(month, day)) {
            System.out.println("It's a Spring Season.");
        } else {
            System.out.println("Not a Spring Season.");
        }
    }
}
