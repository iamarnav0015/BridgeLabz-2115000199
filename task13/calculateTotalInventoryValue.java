class InventoryNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    InventoryNode next;

    public InventoryNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManagementSystem {
    private InventoryNode head;

    // Add an item at the beginning
    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    // Add an item at the end
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price);
        if (head == null) {
            head = newNode;
        } else {
            InventoryNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Add an item at a specific position
    public void addAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }

        if (position == 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }

        InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price);
        InventoryNode current = head;

        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of bounds!");
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Remove an item by Item ID
    public void removeByItemId(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item with ID " + itemId + " removed.");
            return;
        }

        InventoryNode current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Item with ID " + itemId + " not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Item with ID " + itemId + " removed.");
        }
    }

    // Update quantity of an item by Item ID
    public void updateQuantityByItemId(int itemId, int newQuantity) {
        InventoryNode current = head;

        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                System.out.println("Quantity updated for item with ID " + itemId + ".");
                return;
            }
            current = current.next;
        }

        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item ID
    public void searchByItemId(int itemId) {
        InventoryNode current = head;

        while (current != null) {
            if (current.itemId == itemId) {
                System.out.println("Found Item: Name: " + current.itemName + ", ID: " + current.itemId +
                        ", Quantity: " + current.quantity + ", Price: " + current.price);
                return;
            }
            current = current.next;
        }

        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item Name
    public void searchByItemName(String itemName) {
        InventoryNode current = head;

        while (current != null) {
            if (current.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Found Item: Name: " + current.itemName + ", ID: " + current.itemId +
                        ", Quantity: " + current.quantity + ", Price: " + current.price);
                return;
            }
            current = current.next;
        }

        System.out.println("Item with Name \"" + itemName + "\" not found.");
    }

    // Calculate and display total value of inventory
    public void calculateTotalInventoryValue() {
        double totalValue = 0;
        InventoryNode current = head;

        while (current != null) {
            totalValue += current.price * current.quantity;
            current = current.next;
        }

        System.out.println("Total Inventory Value: $" + totalValue);
    }

    // Sort inventory by Item Name in ascending order
    public void sortByName() {
        if (head == null || head.next == null) return;

        head = mergeSort(head, true);
        System.out.println("Inventory sorted by Item Name.");
    }

    // Sort inventory by Price in ascending order
    public void sortByPrice() {
        if (head == null || head.next == null) return;

        head = mergeSort(head, false);
        System.out.println("Inventory sorted by Price.");
    }

    private InventoryNode mergeSort(InventoryNode node, boolean sortByName) {
        if (node == null || node.next == null) return node;

        InventoryNode middle = getMiddle(node);
        InventoryNode nextOfMiddle = middle.next;
        middle.next = null;

        InventoryNode left = mergeSort(node, sortByName);
        InventoryNode right = mergeSort(nextOfMiddle, sortByName);

        return merge(left, right, sortByName);
    }

    private InventoryNode merge(InventoryNode left, InventoryNode right, boolean sortByName) {
        if (left == null) return right;
        if (right == null) return left;

        InventoryNode result;

        if (sortByName) {
            if (left.itemName.compareToIgnoreCase(right.itemName) <= 0) {
                result = left;
                result.next = merge(left.next, right, true);
            } else {
                result = right;
                result.next = merge(left, right.next, true);
            }
        } else {
            if (left.price <= right.price) {
                result = left;
                result.next = merge(left.next, right, false);
            } else {
                result = right;
                result.next = merge(left, right.next, false);
            }
        }

        return result;
    }

    private InventoryNode getMiddle(InventoryNode node) {
        if (node == null) return node;

        InventoryNode slow = node, fast = node.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();

        // Adding items
        inventory.addAtBeginning("Laptop", 101, 10, 800.00);
        inventory.addAtEnd("Mouse", 102, 50, 25.00);
        inventory.addAtPosition(2, "Keyboard", 103, 30, 45.00);

        // Displaying inventory
        inventory.calculateTotalInventoryValue();

        // Search operations
        inventory.searchByItemId(102);
        inventory.searchByItemName("Keyboard");

        // Update quantity
        inventory.updateQuantityByItemId(101, 15);

        // Sorting
        inventory.sortByName();
        inventory.sortByPrice();

        // Remove an item
        inventory.removeByItemId(103);

        // Display total value after removal
        inventory.calculateTotalInventoryValue();
    }
}
