import java.util.regex.*;
import java.util.*;

public class DateExtractor {
    public static List<String> extractDates(String text) {
        // Define the regex pattern for dates in dd/mm/yyyy format
        String regex = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}\\b";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(text);

        // List to store extracted dates
        List<String> dates = new ArrayList<>();

        // Find and add all matches to the list
        while (matcher.find()) {
            dates.add(matcher.group());
        }

        return dates;
    }

    public static void main(String[] args) {
        // Example text
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        // Extract and print dates
        List<String> dates = extractDates(text);
        System.out.println(dates);
    }
}
