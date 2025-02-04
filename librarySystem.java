class Book {
    private static String libraryName = "City Central Library";

    private String title;
    private String author;
    private final String isbn;
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        System.out.println("Book added: " + title + " by " + author + " (ISBN: " + isbn + ")");
    }
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
    public void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        } else {
            System.out.println("Invalid book object.");
        }
    }
}

public class librarySystem {
    public static void main(String[] args) {
        Book.displayLibraryName();
        Book book1 = new Book("1984", "George Orwell", "978-0451524935");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084");
        book1.displayBookDetails();
        book2.displayBookDetails();
    }
}
