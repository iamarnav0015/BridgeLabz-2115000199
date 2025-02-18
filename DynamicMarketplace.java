import java.util.ArrayList;
import java.util.List;

// Abstract class representing a product category
abstract class ProductCategory {
    private String categoryName;

    public ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}

// Specific categories
class BookCategory extends ProductCategory {
    public BookCategory() {
        super("Books");
    }
}

class ClothingCategory extends ProductCategory {
    public ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends ProductCategory {
    public GadgetCategory() {
        super("Gadgets");
    }
}

// Generic Product class with bounded type parameter
class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;



    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ("Category: " + category.getCategoryName() + "Price: $  " + price  );
    }
}

// Generic method to apply discounts
class MarketplaceUtils {
    public static <T extends Product<?>> void applyDiscount(T product,
                                                            double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
    }
}

// Marketplace class to manage product catalog
class Marketplace {
    private List<Product<?>> catalog = new ArrayList<>();



    public void addProduct(Product<?> product) {
        catalog.add(product);
    }

    public void displayCatalog() {
        for (Product<?> product : catalog) {
            System.out.println(product);
        }
    }
}

public class DynamicMarketplace {
    public static void main(String[] args) {
        Marketplace marketplace = new Marketplace();

        Product<BookCategory> book = new Product<>("Java Programming",
                39.99, new BookCategory());
        Product<ClothingCategory> clothing = new Product<>("T-Shirt", 19.99,
                new ClothingCategory());
        Product<GadgetCategory> gadget = new Product<>("Smartphone", 499.99,
                new GadgetCategory());

        marketplace.addProduct(book);
        marketplace.addProduct(clothing);
        marketplace.addProduct(gadget);

        System.out.println("Before Discount:");
        marketplace.displayCatalog();

        MarketplaceUtils.applyDiscount(book, 10);
        MarketplaceUtils.applyDiscount(clothing, 5);
        MarketplaceUtils.applyDiscount(gadget, 15);

        System.out.println("\nAfter Discount:");
        marketplace.displayCatalog();
    }
}