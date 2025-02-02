public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private static final double DAILY_RENTAL_COST = 50.0; // Fixed daily rental rate

    // Default constructor
    public CarRental() {
        this.customerName = "Unknown";
        this.carModel = "Not specified";
        this.rentalDays = 0;
    }

    // Parameterized constructor
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    // Method to calculate total rental cost
    public double calculateTotalCost() {
        return rentalDays * DAILY_RENTAL_COST;
    }

    @Override
    public String toString() {
        return "CarRental(Customer Name: " + customerName +
                ", Car Model: " + carModel +
                ", Rental Days: " + rentalDays +
                ", Total Cost: $" + calculateTotalCost() + ")";
    }

    public static void main(String[] args) {
        // Default constructor example
        CarRental rental1 = new CarRental();
        System.out.println(rental1);

        // Parameterized constructor example
        CarRental rental2 = new CarRental("Alice Johnson", "Toyota Camry", 5);
        System.out.println(rental2);

        // Another rental example
        CarRental rental3 = new CarRental("Bob Smith", "Honda Accord", 3);
        System.out.println(rental3);
    }
}
