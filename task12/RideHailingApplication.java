import java.util.*;

// Abstract Vehicle Class
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        if (ratePerKm > 0) {
            this.ratePerKm = ratePerKm;
        }
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: $" + ratePerKm);
    }
}

// GPS Interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

// Car Class
class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String location) {
        this.currentLocation = location;
        System.out.println("Car location updated to: " + location);
    }
}

// Bike Class
class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.9; // 10% discount for bikes
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String location) {
        this.currentLocation = location;
        System.out.println("Bike location updated to: " + location);
    }
}

// Auto Class
class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 1.1; // 10% additional charge for autos
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String location) {
        this.currentLocation = location;
        System.out.println("Auto location updated to: " + location);
    }
}

public class RideHailingApplication {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle car = new Car("V001", "Alice Brown", 2.0);
        Vehicle bike = new Bike("V002", "Bob Smith", 1.5);
        Vehicle auto = new Auto("V003", "Charlie Davis", 1.8);

        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(auto);

        double distance = 10.0; // Sample distance for fare calculation

        for (Vehicle vehicle : vehicles) {
            vehicle.getVehicleDetails();
            System.out.println("Fare for " + distance + " km: $" + vehicle.calculateFare(distance));
            if (vehicle instanceof GPS) {
                GPS gpsEnabledVehicle = (GPS) vehicle;
                gpsEnabledVehicle.updateLocation("Downtown");
                System.out.println("Current Location: " + gpsEnabledVehicle.getCurrentLocation());
            }
            System.out.println("---------------------------");
        }
    }
}