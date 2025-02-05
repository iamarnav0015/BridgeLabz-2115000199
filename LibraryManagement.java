import java.util.ArrayList;
public class LibraryManagement {

    // Book Class
    public static class Book {
        private String title;
        private String author;

        // Constructor
        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        // Getter methods
        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        // Method to display book information
        public void displayBook() {
            System.out.println("Title: " + title + ", Author: " + author);
        }
    }

    // Library Class
    public static class Library {
        private ArrayList<Book> books;

        // Constructor
        public Library() {
            this.books = new ArrayList<>();
        }

        // Method to add a book to the library
        public void addBook(Book book) {
            books.add(book);
        }

        // Method to display all books in the library
        public void displayBooks() {
            System.out.println("Books in this library:");
            for (Book book : books) {
                book.displayBook();
            }
        }
    }

    // Main method to demonstrate the aggregation relationship
    public static void main(String[] args) {
        // Creating book objects
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald");

        // Creating library objects
        Library library1 = new Library();
        Library library2 = new Library();

        // Adding books to libraries
        library1.addBook(book1);
        library1.addBook(book2);
        library2.addBook(book3);

        // Displaying books in each library
        System.out.println("Library 1:");
        library1.displayBooks();

        System.out.println("\nLibrary 2:");
        library2.displayBooks();
    }
}
