import java.time.LocalDate;

public class DateArithmetic {
    public static void main(String[] args) {
        // Take a date input (e.g., today's date)
        LocalDate inputDate = LocalDate.now();

        // Add 7 days, 1 month, and 2 years
        LocalDate newDate = inputDate.plusDays(7).plusMonths(1).plusYears(2);

        // Subtract 3 weeks
        LocalDate resultDate = newDate.minusWeeks(3);

        // Print the results
        System.out.println("Input Date: " + inputDate);
        System.out.println("After Adding 7 Days, 1 Month, 2 Years: " + newDate);
        System.out.println("After Subtracting 3 Weeks: " + resultDate);
    }
}

