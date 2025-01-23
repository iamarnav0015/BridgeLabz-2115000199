import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        if (year >= 1582) { // Gregorian calendar starts from 1582
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                System.out.println("This is a Leap year");
            } else {
                System.out.println("This year is not a leap year");
            }
        } else {
            System.out.println("Invalid input. The Gregorian calendar started in 1582.");
        }
    }
}
