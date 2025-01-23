import java.util.Scanner;

public class FriendsComparision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declare variables for ages and heights
        int ageAmar, ageAkbar, ageAnthony;
        double heightAmar, heightAkbar, heightAnthony;

        // Input age and height for Amar
        System.out.print("Enter Amar's age: ");
        ageAmar = scanner.nextInt();
        System.out.print("Enter Amar's height (in cm): ");
        heightAmar = scanner.nextDouble();

        // Input age and height for Akbar
        System.out.print("Enter Akbar's age: ");
        ageAkbar = scanner.nextInt();
        System.out.print("Enter Akbar's height (in cm): ");
        heightAkbar = scanner.nextDouble();

        // Input age and height for Anthony
        System.out.print("Enter Anthony's age: ");
        ageAnthony = scanner.nextInt();
        System.out.print("Enter Anthony's height (in cm): ");
        heightAnthony = scanner.nextDouble();
        int youngestAge = Math.min(ageAmar, Math.min(ageAkbar, ageAnthony));
        String youngestFriend;
        if (youngestAge == ageAmar) {
            youngestFriend = "Amar";
        } else if (youngestAge == ageAkbar) {
            youngestFriend = "Akbar";
        } else {
            youngestFriend = "Anthony";
        }
        double tallestHeight = Math.max(heightAmar, Math.max(heightAkbar, heightAnthony));
        String tallestFriend;
        if (tallestHeight == heightAmar) {
            tallestFriend = "Amar";
        } else if (tallestHeight == heightAkbar) {
            tallestFriend = "Akbar";
        } else {
            tallestFriend = "Anthony";
        }
        System.out.println("The youngest friend is " + youngestFriend + " with an age of " + youngestAge + " years.");
        System.out.println("The tallest friend is " + tallestFriend + " with a height of " + tallestHeight + " cm.");
    }
}
