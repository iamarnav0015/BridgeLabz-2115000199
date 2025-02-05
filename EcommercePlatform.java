import java.util.ArrayList;

// Customer class representing a customer who places orders
class Customer1 {
    String name;
    ArrayList<Order> orders; // Association: A Customer places multiple Orders

    Customer1(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    // Method to place an order
    void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed an order with Order ID: " + order.orderId);
    }

    // View orders placed by the customer
    void viewOrders() {
        System.out.println(name + "'s Orders:");
        for (Order order : orders) {
            System.out.println("Order ID: " + order.orderId);
            order.viewProducts();
        }
    }
}

// Product class representing a product that can be ordered
class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// Order class representing an order that contains multiple products
class Order {
    int orderId;
    ArrayList<Product> products; // Aggregation: Order contains multiple Products

    Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    // Method to add a product to the order
    void addProduct(Product product) {
        products.add(product);
    }

    // View products in the order
    void viewProducts() {
        System.out.println("Products in Order ID " + orderId + ":");
        for (Product product : products) {
            System.out.println(product.name + " - ₹" + product.price);
        }
    }
}

// Main class to demonstrate the relationships
public class EcommercePlatform {
    public static void main(String[] args) {
        // Create Customers
        Customer1 akash = new Customer1("Akash Mehta");
        Customer1 priya = new Customer1("Priya Sharma");

        // Create Products
        Product laptop = new Product("Laptop", 50000);
        Product phone = new Product("Smartphone", 20000);
        Product headphones = new Product("Headphones", 3000);

        // Create Orders
        Order order1 = new Order(101);
        order1.addProduct(laptop);
        order1.addProduct(headphones);

        Order order2 = new Order(102);
        order2.addProduct(phone);

        // Customers place orders
        akash.placeOrder(order1);
        priya.placeOrder(order2);

        // View customer orders
        akash.viewOrders();
        priya.viewOrders();
    }
}

