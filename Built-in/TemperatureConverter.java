import java.util.Scanner;

public class TemperatureConverter {
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature: ");
        double temp = scanner.nextDouble();
        System.out.print("Convert to (C)elsius or (F)ahrenheit? ");
        char choice = scanner.next().toUpperCase().charAt(0);
        if (choice == 'C') {
            System.out.println("Converted: " + fahrenheitToCelsius(temp) + "°C");
        } else if (choice == 'F') {
            System.out.println("Converted: " + celsiusToFahrenheit(temp) + "°F");
        } else {
            System.out.println("Invalid choice.");
        }
    }
}

