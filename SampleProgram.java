import java.util.Scanner;

public class SampleProgram{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the name of the traveler
        System.out.print("Enter the name of the traveler: ");
        String name = scanner.nextLine();

        // Input the names of the cities
        System.out.print("Enter the starting city (fromCity): ");
        String fromCity = scanner.nextLine();

        System.out.print("Enter the city you pass through (viaCity): ");
        String viaCity = scanner.nextLine();

        System.out.print("Enter the destination city (toCity): ");
        String toCity = scanner.nextLine();

        // Input the distances in kilometers
        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " (in km): ");
        double distanceFromToVia = scanner.nextDouble();

        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " (in km): ");
        double distanceViaToFinalCity = scanner.nextDouble();

        // Input the travel times in hours and minutes
        System.out.print("Enter the time taken from " + fromCity + " to " + viaCity + " (in hours): ");
        int timeFromToViaHours = scanner.nextInt();
        System.out.print("Enter the time taken from " + fromCity + " to " + viaCity + " (in minutes): ");
        int timeFromToViaMinutes = scanner.nextInt();

        System.out.print("Enter the time taken from " + viaCity + " to " + toCity + " (in hours): ");
        int timeViaToFinalCityHours = scanner.nextInt();
        System.out.print("Enter the time taken from " + viaCity + " to " + toCity + " (in minutes): ");
        int timeViaToFinalCityMinutes = scanner.nextInt();

        // Calculate total distance
        double totalDistance = distanceFromToVia + distanceViaToFinalCity;

        // Calculate total time in minutes
        int totalTimeMinutes = (timeFromToViaHours * 60 + timeFromToViaMinutes) +
                (timeViaToFinalCityHours * 60 + timeViaToFinalCityMinutes);

        // Print the travel details
        System.out.println("\nTravel Details:");
        System.out.println("The Total Distance travelled by " + name + " from " +
                fromCity + " to " + toCity + " via " + viaCity + " is " + totalDistance + " km.");
        System.out.println("The Total Time taken is " + totalTimeMinutes + " minutes.");

    }
}
