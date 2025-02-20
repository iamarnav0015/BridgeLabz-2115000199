import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();
    private TreeMap<Double, String> sortedProducts = new TreeMap<>();

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        cart.put(product, cart.getOrDefault(product, 0) + 1);
        sortedProducts.put(price, product);
    }

    public void removeProduct(String product) {
        if (cart.containsKey(product)) {
            cart.remove(product);
            sortedProducts.remove(productPrices.get(product));
            productPrices.remove(product);
        }
    }

    public void displayCart() {
        System.out.println("Cart (Insertion Order): " + cart);
        System.out.println("Products Sorted by Price: " + sortedProducts);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += productPrices.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Laptop", 50000);
        cart.addProduct("Phone", 30000);
        cart.addProduct("Tablet", 20000);
        cart.addProduct("Phone", 30000);

        cart.displayCart();
        System.out.println("Total Price: " + cart.getTotalPrice());
    }
}
