
public class UnitConverter3 {
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }

    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    public static void main(String[] args) {
        System.out.println("100°F to Celsius: " + convertFahrenheitToCelsius(100));
        System.out.println("37°C to Fahrenheit: " + convertCelsiusToFahrenheit(37));
        System.out.println("10 pounds to kilograms: " + convertPoundsToKilograms(10));
        System.out.println("10 kilograms to pounds: " + convertKilogramsToPounds(10));
        System.out.println("10 gallons to liters: " + convertGallonsToLiters(10));
    }
}

