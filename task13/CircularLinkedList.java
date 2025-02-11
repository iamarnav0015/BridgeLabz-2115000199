class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    public TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class CircularLinkedList {
    private TicketNode last;

    public CircularLinkedList() {
        this.last = null;
    }

    // Add a new ticket reservation at the end of the circular list
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newNode = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (last == null) { // List is empty
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        System.out.println("Ticket with ID " + ticketId + " added successfully.");
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (last == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        TicketNode current = last.next;
        TicketNode prev = last;
        boolean found = false;

        do {
            if (current.ticketId == ticketId) {
                found = true;
                break;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);

        if (!found) {
            System.out.println("Ticket with ID " + ticketId + " not found.");
            return;
        }

        // Handle the removal cases
        if (current == last.next && current == last) { // Only one node
            last = null;
        } else if (current == last.next) { // First node
            last.next = current.next;
        } else if (current == last) { // Last node
            prev.next = current.next;
            last = prev;
        } else { // Middle node
            prev.next = current.next;
        }

        System.out.println("Ticket with ID " + ticketId + " removed successfully.");
    }

    // Display the current tickets in the list
    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets to display.");
            return;
        }

        TicketNode current = last.next;
        System.out.println("Current tickets in the system:");
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer Name: " + current.customerName + ", Movie Name: " + current.movieName + ", Seat Number: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != last.next);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String searchTerm) {
        if (last == null) {
            System.out.println("No tickets to search.");
            return;
        }

        TicketNode current = last.next;
        boolean found = false;
        do {
            if (current.customerName.toLowerCase().contains(searchTerm.toLowerCase()) || current.movieName.toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("Found Ticket - Ticket ID: " + current.ticketId + ", Customer Name: " + current.customerName + ", Movie Name: " + current.movieName + ", Seat Number: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != last.next);

        if (!found) {
            System.out.println("No tickets found for search term: " + searchTerm);
        }
    }

    // Calculate the total number of booked tickets
    public int totalTickets() {
        if (last == null) {
            System.out.println("Total tickets: 0");
            return 0;
        }

        int count = 0;
        TicketNode current = last.next;
        do {
            count++;
            current = current.next;
        } while (current != last.next);

        System.out.println("Total tickets: " + count);
        return count;
    }

    public static void main(String[] args) {
        CircularLinkedList system = new CircularLinkedList();

        // Adding tickets
        system.addTicket(101, "Alice", "Inception", "A1", "10:00 AM");
        system.addTicket(102, "Bob", "Interstellar", "B2", "1:00 PM");
        system.addTicket(103, "Charlie", "Dune", "C3", "3:00 PM");

        // Displaying tickets
        system.displayTickets();

        // Searching for a ticket
        system.searchTicket("Alice");

        // Removing a ticket
        system.removeTicket(102);

        // Displaying tickets after removal
        system.displayTickets();

        // Calculating total tickets
        system.totalTickets();
    }
}
