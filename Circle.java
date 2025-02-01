public class Circle {
    private double radius;

    // Default constructor
    public Circle() {
        this(1.0); // Constructor chaining to set default radius
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate the area of the circle
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate the circumference of the circle
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Method to display circle details
    public void displayInfo() {
        System.out.println("Radius: " + radius);
        System.out.printf("Area: %.2f%n", calculateArea());
        System.out.printf("Circumference: %.2f%n", calculateCircumference());
    }

    // Main method for demonstration
    public static void main(String[] args) {
        // Default constructor
        Circle defaultCircle = new Circle();
        defaultCircle.displayInfo();

        System.out.println();

        // Parameterized constructor
        Circle customCircle = new Circle(5.5);
        customCircle.displayInfo();
    }
}
