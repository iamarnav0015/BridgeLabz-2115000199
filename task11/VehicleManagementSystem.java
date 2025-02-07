interface Refuelable {
    void refuel();
}

class Vehicle1 {
    protected String model;
    protected int maxSpeed;

    public Vehicle1(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

class ElectricVehicle extends Vehicle1 {
    public ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    public void charge() {
        displayInfo();
        System.out.println("Charging the electric vehicle.");
    }
}

class PetrolVehicle extends Vehicle1 implements Refuelable {
    public PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    @Override
    public void refuel() {
        displayInfo();
        System.out.println("Refueling the petrol vehicle.");
    }
}

public class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model S", 250);
        PetrolVehicle pv = new PetrolVehicle("Ford Mustang", 240);

        System.out.println("Vehicle Information:");
        ev.charge();
        System.out.println();
        pv.refuel();
    }
}

