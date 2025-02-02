public class Books {
    private String title;
    private String author;
    private double price;
    private boolean available;

    // Default constructor
    public Books() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
        this.available = true;
    }

    // Parameterized constructor
    public Books(String title, String author, double price, boolean available) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }

    // Copy constructor
    public Books(Books otherBook) {
        if (otherBook == null) {
            throw new IllegalArgumentException("Cannot copy from a null book.");
        }
        this.title = otherBook.title;
        this.author = otherBook.author;
        this.price = otherBook.price;
        this.available = otherBook.available;
    }

    // Method to borrow a book
    public boolean borrowBook() {
        if (available) {
            available = false;
            System.out.println("You have successfully borrowed the book: " + title);
            return true;
        } else {
            System.out.println("Sorry, the book: " + title + " is currently unavailable.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Book(title=" + title + ", author=" + author + ", price=" + price + ", available=" + available + ")";
    }

    public static void main(String[] args) {
        // Default constructor
        Books book1 = new Books();
        System.out.println("Default book: " + book1);

        // Parameterized constructor
        Books book2 = new Books("1984", "George Orwell", 9.99, true);
        System.out.println("Parameterized book: " + book2);

        // Copy constructor
        Books book3 = new Books(book2);
        System.out.println("Cloned book: " + book3);

        // Borrow a book
        book2.borrowBook();
        book2.borrowBook();  // Try borrowing again to test availability
    }
}
