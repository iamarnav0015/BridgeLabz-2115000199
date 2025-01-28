import java.util.Scanner;

public class LeapYearCheck {
    public static boolean isLeapYear(int year) {
        return year >= 1582 && (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a year (>= 1582): ");
        int year = s.nextInt();
        if (year >= 1582) {
            System.out.println(year + (isLeapYear(year) ? " is a Leap Year." : " is not a Leap Year."));
        } else System.out.println("Year must be >= 1582.");
    }
}
