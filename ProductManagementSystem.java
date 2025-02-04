class Product {
    private static double discount = 0.0;
    private static int productCount = 0;

    private String productName;
    private final int productID;
    private double price;
    private int quantity;

    public Product(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = ++productCount;
        System.out.println("Product added: " + productName + " (ID: " + productID + ", Price: $" + price + ", Quantity: " + quantity + ")");
    }

    public static void updateDiscount(double newDiscount) {
        if (newDiscount >= 0 && newDiscount <= 100) {
            discount = newDiscount;
            System.out.println("Discount updated to: " + discount + "%");
        } else {
            System.out.println("Invalid discount value. Must be between 0% and 100%.");
        }
    }

    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product Name: " + productName);
            System.out.println("Product ID: " + productID);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
        } else {
            System.out.println("Invalid product object.");
        }
    }
}

public class ProductManagementSystem {
    public static void main(String[] args) {
        Product.updateDiscount(10.0);
        Product product1 = new Product("Laptop", 75000.00, 2);
        Product product2 = new Product("Smartphone", 65000.00, 5);
        product1.displayProductDetails();
        product2.displayProductDetails();
        Product.updateDiscount(15.0);
        product1.displayProductDetails();
        product2.displayProductDetails();
    }
}
