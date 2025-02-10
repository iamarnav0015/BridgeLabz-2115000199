import java.util.*;

// Abstract FoodItem Class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
    }
}

// Discountable Interface
interface Discountable {
    void applyDiscount(double discountRate);
    void getDiscountDetails();
}

// VegItem Class
class VegItem extends FoodItem implements Discountable {
    private double discount;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discount = 0.0;
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() - discount;
    }

    @Override
    public void applyDiscount(double discountRate) {
        discount = getPrice() * getQuantity() * discountRate;
        System.out.println("Discount of $" + discount + " applied.");
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("Discount Amount: $" + discount);
    }
}

// NonVegItem Class
class NonVegItem extends FoodItem implements Discountable {
    private double additionalCharge;
    private double discount;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.additionalCharge = 5.0; // Fixed additional charge per item
        this.discount = 0.0;
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() + additionalCharge) * getQuantity() - discount;
    }

    @Override
    public void applyDiscount(double discountRate) {
        discount = (getPrice() + additionalCharge) * getQuantity() * discountRate;
        System.out.println("Discount of $" + discount + " applied.");
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("Discount Amount: $" + discount);
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();

        order.add(new VegItem("Salad", 10.0, 2));
        order.add(new NonVegItem("Chicken Burger", 15.0, 1));

        // Process and display order details
        for (FoodItem item : order) {
            item.getItemDetails();
            if (item instanceof Discountable) {
                Discountable discountableItem = (Discountable) item;
                discountableItem.applyDiscount(0.10); // 10% discount
                discountableItem.getDiscountDetails();
            }
            System.out.println("Total Price: $" + item.calculateTotalPrice());
            System.out.println("---------------------------");
        }
    }
}
-