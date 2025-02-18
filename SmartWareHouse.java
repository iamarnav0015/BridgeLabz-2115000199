import java.util.ArrayList;
import java.util.List;

// Abstract class representing a warehouse item
abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + name;
    }
}

// Specific item types
class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }


}

class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }
}

// Generic storage class with bounded type parameter
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    public List<T> getAllItems() {
        return items;
    }
}

// Utility class for displaying items
class WarehouseUtils {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

public class SmartWareHouse {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));
        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Apple"));
        groceriesStorage.addItem(new Groceries("Milk"));
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Table"));
        furnitureStorage.addItem(new Furniture("Chair"));
        System.out.println("Electronics in storage:");

        WarehouseUtils.displayItems(electronicsStorage.getAllItems());
        System.out.println("\nGroceries in storage:");
        WarehouseUtils.displayItems(groceriesStorage.getAllItems());
        System.out.println("\nFurniture in storage:");
        WarehouseUtils.displayItems(furnitureStorage.getAllItems());
    }
}