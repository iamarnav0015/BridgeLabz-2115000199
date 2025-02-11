class MovieNode {
    String title;
    String director;
    int yearOfRelease;
    double rating;
    MovieNode next;
    MovieNode prev;

    public MovieNode(String title, String director, int yearOfRelease, double rating) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

public class MovieManagementSystem {
    private MovieNode head;
    private MovieNode tail;

    // Add a movie at the beginning
    public void addAtBeginning(String title, String director, int yearOfRelease, double rating) {
        MovieNode newNode = new MovieNode(title, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add a movie at the end
    public void addAtEnd(String title, String director, int yearOfRelease, double rating) {
        MovieNode newNode = new MovieNode(title, director, yearOfRelease, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add a movie at a specific position
    public void addAtPosition(int position, String title, String director, int yearOfRelease, double rating) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }

        if (position == 1) {
            addAtBeginning(title, director, yearOfRelease, rating);
            return;
        }

        MovieNode newNode = new MovieNode(title, director, yearOfRelease, rating);
        MovieNode current = head;

        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of bounds!");
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            } else {
                tail = newNode;
            }
            current.next = newNode;
        }
    }

    // Remove a movie by title
    public void removeByTitle(String title) {
        if (head == null) {
            System.out.println("No movies to remove.");
            return;
        }

        MovieNode current = head;

        while (current != null && !current.title.equalsIgnoreCase(title)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Movie with title \"" + title + "\" not found.");
        } else {
            if (current == head) {
                head = current.next;
            }
            if (current == tail) {
                tail = current.prev;
            }
            if (current.prev != null) {
                current.prev.next = current.next;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            System.out.println("Movie with title \"" + title + "\" removed.");
        }
    }

    // Search for movies by director
    public void searchByDirector(String director) {
        MovieNode current = head;
        boolean found = false;

        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                System.out.println("Found Movie: " + current.title + " (" + current.yearOfRelease + "), Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No movies found by director \"" + director + "\".");
        }
    }

    // Search for movies by rating
    public void searchByRating(double rating) {
        MovieNode current = head;
        boolean found = false;

        while (current != null) {
            if (current.rating == rating) {
                System.out.println("Found Movie: " + current.title + " by " + current.director + ", Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No movies found with rating " + rating);
        }
    }

    // Display all movie records in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("No movie records found.");
            return;
        }

        MovieNode current = head;
        System.out.println("Movies in Forward Order:");
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director +
                    ", Year: " + current.yearOfRelease + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display all movie records in reverse order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movie records found.");
            return;
        }

        MovieNode current = tail;
        System.out.println("Movies in Reverse Order:");
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director +
                    ", Year: " + current.yearOfRelease + ", Rating: " + current.rating);
            current = current.prev;
        }
    }

    // Update a movie's rating by title
    public void updateRatingByTitle(String title, double newRating) {
        MovieNode current = head;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated for movie \"" + title + "\".");
                return;
            }
            current = current.next;
        }

        System.out.println("Movie with title \"" + title + "\" not found.");
    }

    public static void main(String[] args) {
        MovieManagementSystem movieList = new MovieManagementSystem();

        // Adding movies
        movieList.addAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.addAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        movieList.addAtPosition(2, "Interstellar", "Christopher Nolan", 2014, 8.6);

        // Display movies in forward and reverse order
        movieList.displayForward();
        movieList.displayReverse();

        // Searching for movies
        movieList.searchByDirector("Christopher Nolan");
        movieList.searchByRating(8.6);

        // Updating a movie's rating
        movieList.updateRatingByTitle("Inception", 9.0);

        // Removing a movie
        movieList.removeByTitle("Interstellar");

        // Displaying movies after deletion
        movieList.displayForward();
    }
}
