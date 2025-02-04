class Vehicle {
    private static double registrationFee = 500.0;
    private String ownerName;

    private String vehicleType;
    private final int registrationNumber;
    private static int registrationCounter = 0;
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = ++registrationCounter;
        System.out.println("Vehicle Registered: " + vehicleType + " (Owner: " + ownerName + ", Registration Number: " + registrationNumber + ")");
    }
    public static void updateRegistrationFee(double newFee) {
        if (newFee > 0) {
            registrationFee = newFee;
            System.out.println("Registration fee updated to: $" + registrationFee);
        } else {
            System.out.println("Invalid registration fee. Must be a positive value.");
        }
    }
    public void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        } else {
            System.out.println("Invalid vehicle object.");
        }
    }
}

public class VehicleRegistrationSystem {
    public static void main(String[] args) {
        Vehicle.updateRegistrationFee(600.0);
        Vehicle vehicle1 = new Vehicle("Alice", "Car");
        Vehicle vehicle2 = new Vehicle("Bob", "Motorcycle");
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
        Vehicle.updateRegistrationFee(700.0);
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
    }
}
