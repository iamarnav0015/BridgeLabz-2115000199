public class Course {
    // Instance variables
    private String courseName;
    private int duration; // in weeks
    private double fee;

    // Class variable (common for all courses)
    private static String instituteName = "Tech Academy";

    // Constructor to initialize course details
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: $" + fee);
        System.out.println("Institute Name: " + instituteName);
        System.out.println("----------------------------");
    }

    // Class method to update the institute name
    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }

    public static void main(String[] args) {
        // Create courses
        Course course1 = new Course("Java Programming", 12, 500.00);
        Course course2 = new Course("Web Development", 10, 450.00);
        Course course3 = new Course("Data Science", 16, 700.00);

        // Display initial course details
        course1.displayCourseDetails();
        course2.displayCourseDetails();
        course3.displayCourseDetails();

        // Update the institute name
        Course.updateInstituteName("Global Tech Institute");

        // Display updated course details
        System.out.println("After updating institute name:");
        course1.displayCourseDetails();
        course2.displayCourseDetails();
        course3.displayCourseDetails();
    }
}
