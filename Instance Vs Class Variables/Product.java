public class Product {
    // Instance variables
    private String productName;
    private double price;

    // Class variable to keep track of total products
    private static int totalProducts = 0;

    // Constructor to initialize product details
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // Increment total products when a new product is created
    }

    // Instance method to display product details
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName + ", Price: $" + price);
    }

    // Class method to display total products created
    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }

    public static void main(String[] args) {
        // Create products
        Product product1 = new Product("Laptop", 1200.50);
        Product product2 = new Product("Smartphone", 899.99);
        Product product3 = new Product("Headphones", 199.99);

        // Display product details
        product1.displayProductDetails();
        product2.displayProductDetails();
        product3.displayProductDetails();

        // Display total number of products created
        Product.displayTotalProducts();
    }
}
