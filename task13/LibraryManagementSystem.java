class BookNode {
    String bookTitle;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    BookNode next;
    BookNode prev;

    public BookNode(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

public class LibraryManagementSystem {
    private BookNode head;
    private BookNode tail;

    // Add a book at the beginning
    public void addAtBeginning(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(bookTitle, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add a book at the end
    public void addAtEnd(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(bookTitle, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add a book at a specific position
    public void addAtPosition(int position, String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }

        if (position == 1) {
            addAtBeginning(bookTitle, author, genre, bookId, isAvailable);
            return;
        }

        BookNode newNode = new BookNode(bookTitle, author, genre, bookId, isAvailable);
        BookNode current = head;

        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of bounds!");
        } else {
            newNode.next = current.next;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    // Remove a book by Book ID
    public void removeByBookId(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        if (head.bookId == bookId) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            System.out.println("Book with ID " + bookId + " removed.");
            return;
        }

        BookNode current = head;

        while (current != null && current.bookId != bookId) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Book with ID " + bookId + " not found.");
        } else {
            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;
            }
            if (current.prev != null) {
                current.prev.next = current.next;
            }
            System.out.println("Book with ID " + bookId + " removed.");
        }
    }

    // Search for a book by Book Title
    public void searchByBookTitle(String bookTitle) {
        BookNode current = head;

        while (current != null) {
            if (current.bookTitle.equalsIgnoreCase(bookTitle)) {
                displayBookInfo(current);
                return;
            }
            current = current.next;
        }

        System.out.println("Book with Title \"" + bookTitle + "\" not found.");
    }

    // Search for a book by Author
    public void searchByAuthor(String author) {
        BookNode current = head;

        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                displayBookInfo(current);
            }
            current = current.next;
        }
    }

    // Update a book’s Availability Status
    public void updateAvailabilityStatus(int bookId, boolean isAvailable) {
        BookNode current = head;

        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = isAvailable;
                System.out.println("Availability status updated for Book with ID " + bookId + ".");
                return;
            }
            current = current.next;
        }

        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display all books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        System.out.println("Books in Forward Order:");
        BookNode current = head;

        while (current != null) {
            displayBookInfo(current);
            current = current.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }

        System.out.println("Books in Reverse Order:");
        BookNode current = tail;

        while (current != null) {
            displayBookInfo(current);
            current = current.prev;
        }
    }

    // Display book information
    private void displayBookInfo(BookNode book) {
        System.out.println("Book Title: " + book.bookTitle + ", Author: " + book.author +
                ", Genre: " + book.genre + ", Book ID: " + book.bookId +
                ", Available: " + (book.isAvailable ? "Yes" : "No"));
    }

    // Count total number of books
    public void countTotalBooks() {
        int count = 0;
        BookNode current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        System.out.println("Total number of books in the library: " + count);
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        // Adding books
        library.addAtBeginning("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 101, true);
        library.addAtEnd("To Kill a Mockingbird", "Harper Lee", "Fiction", 102, true);
        library.addAtPosition(2, "1984", "George Orwell", "Dystopian", 103, true);

        // Display books forward and reverse
        library.displayBooksForward();
        library.displayBooksReverse();

        // Search operations
        library.searchByBookTitle("1984");
        library.searchByAuthor("Harper Lee");

        // Update availability
        library.updateAvailabilityStatus(101, false);

        // Remove a book
        library.removeByBookId(103);

        // Count total books
        library.countTotalBooks();
    }
}
