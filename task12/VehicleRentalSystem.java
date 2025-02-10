import java.util.*;
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }
    public abstract double calculateRentalCost(int days);

    public void displayVehicleDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate: $" + rentalRate + " per day");
    }
}
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}
class Car extends Vehicle implements Insurable {
    private static final double INSURANCE_RATE = 0.05;

    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * INSURANCE_RATE;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Rate for Car: 5%";
    }
}class Bike extends Vehicle implements Insurable {
    private static final double INSURANCE_RATE = 0.03; // 3% insurance rate

    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * INSURANCE_RATE;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Rate for Bike: 3%";
    }
}
class Truck extends Vehicle {
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 50; // Flat $50 additional fee
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        // Create a list of vehicles
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("C123", 100));
        vehicles.add(new Bike("B456", 50));
        vehicles.add(new Truck("T789", 200));
        for (Vehicle vehicle : vehicles) {
            vehicle.displayVehicleDetails();
            int rentalDays = 5;
            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            System.out.println("Rental Cost for " + rentalDays + " days: $" + rentalCost);
            if (vehicle instanceof Insurable) {
                double insuranceCost = ((Insurable) vehicle).calculateInsurance();
                System.out.println(((Insurable) vehicle).getInsuranceDetails());
                System.out.println("Insurance Cost: $" + insuranceCost);
            }
            System.out.println("---------------------------");
        }
    }
}