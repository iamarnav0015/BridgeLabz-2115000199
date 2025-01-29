import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatting {
    public static void main(String[] args) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Define custom date formats
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        // Print the formatted dates
        System.out.println("Current Date (dd/MM/yyyy): " + currentDate.format(format1));
        System.out.println("Current Date (yyyy-MM-dd): " + currentDate.format(format2));
        System.out.println("Current Date (EEE, MMM dd, yyyy): " + currentDate.format(format3));
    }
}

