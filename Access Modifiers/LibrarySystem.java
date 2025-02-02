// Base class: Book
class Book2 {
    public String ISBN;
    protected String title;
    private String author;

    // Constructor to initialize book details
    public Book2(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Setter for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Subclass: EBook
class EBook extends Book2 {
    private double fileSize; // in MB

    public EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }

    public void displayEBookDetails() {
        System.out.println("E-Book Details:");
        System.out.println("ISBN: " + ISBN); // Accessing public member from superclass
        System.out.println("Title: " + title); // Accessing protected member from superclass
        System.out.println("File Size: " + fileSize + " MB");
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        // Create a Book object
        Book2 book1 = new Book2("978-3-16-148410-0", "Effective Java", "Joshua Bloch");
        book1.displayBookDetails();
        System.out.println();

        // Modify and get the author name
        book1.setAuthor("Updated Author");
        System.out.println("Updated Author: " + book1.getAuthor());
        System.out.println();

        // Create an EBook object
        EBook eBook1 = new EBook("978-0-13-468599-1", "Clean Code", "Robert C. Martin", 5.5);
        eBook1.displayEBookDetails();
    }
}
