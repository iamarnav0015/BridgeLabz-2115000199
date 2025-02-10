import java.util.*;

// Abstract Product Class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract method to calculate discount
    public abstract double calculateDiscount();

    public void displayProductDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
    }
}

// Taxable Interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Electronics Product Class
class Electronics extends Product implements Taxable {
    private static final double TAX_RATE = 0.15; // 15% tax

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * TAX_RATE;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate for Electronics: 15%";
    }
}

// Clothing Product Class
class Clothing extends Product implements Taxable {
    private static final double TAX_RATE = 0.08; // 8% tax

    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * TAX_RATE;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate for Clothing: 8%";
    }
}

// Groceries Product Class
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

public class Ecommerce{
    public static void main(String[] args) {
        // Create a list of products
        List<Product> products = new ArrayList<>();

        products.add(new Electronics(1, "Laptop", 1200));
        products.add(new Clothing(2, "Jeans", 80));
        products.add(new Groceries(3, "Apples", 20));

        // Process and display final price for each product
        for (Product product : products) {
            product.displayProductDetails();
            double discount = product.calculateDiscount();
            double tax = 0;

            if (product instanceof Taxable) {
                tax = ((Taxable) product).calculateTax();
                System.out.println(((Taxable) product).getTaxDetails());
            }

            double finalPrice = product.getPrice() + tax - discount;
            System.out.println("Discount: $" + discount);
            System.out.println("Tax: $" + tax);
            System.out.println("Final Price: $" + finalPrice);
            System.out.println("---------------------------");
        }
    }
}
