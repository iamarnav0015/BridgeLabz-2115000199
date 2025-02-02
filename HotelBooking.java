public class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;

    // Default constructor
    public HotelBooking() {
        this.guestName = "";
        this.roomType = "Standard";
        this.nights = 1;
    }

    // Parameterized constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    public HotelBooking(HotelBooking otherBooking) {
        if (otherBooking == null) {
            throw new IllegalArgumentException("Cannot copy from a null booking.");
        }
        this.guestName = otherBooking.guestName;
        this.roomType = otherBooking.roomType;
        this.nights = otherBooking.nights;
    }

    @Override
    public String toString() {
        return "HotelBooking(guestName=" + guestName + ", roomType=" + roomType + ", nights=" + nights + ")";
    }

    public static void main(String[] args) {
        // Default constructor
        HotelBooking booking1 = new HotelBooking();
        System.out.println("Default booking: " + booking1);

        // Parameterized constructor
        HotelBooking booking2 = new HotelBooking("John Doe", "Deluxe", 3);
        System.out.println("Parameterized booking: " + booking2);

        // Copy constructor
        HotelBooking booking3 = new HotelBooking(booking2);
        System.out.println("Cloned booking: " + booking3);
    }
}
