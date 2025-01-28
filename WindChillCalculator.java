import java.util.Scanner;
public class WindChillCalculator {
    // Method to calculate the wind chill temperature
    public static double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) *
                Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// Get input for temperature and wind speed from the user
        System.out.print("Enter the temperature in Fahrenheit: ");
        double temperature = scanner.nextDouble();
        System.out.print("Enter the wind speed in miles per hour: ");
        double windSpeed = scanner.nextDouble();
// Calculate the wind chill temperature
        double windChill = calculateWindChill(temperature, windSpeed);
// Display the result
        System.out.println("The wind chill temperature is: " + windChill);
    }
}