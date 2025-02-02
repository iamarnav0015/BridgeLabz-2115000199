// Base class: Student
class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    // Constructor to initialize student details
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public getter for CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public setter for CGPA
    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 4.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA. Please enter a value between 0.0 and 4.0.");
        }
    }

    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

// Subclass: PostgraduateStudent
class PostgraduateStudent extends Student {
    private String researchTopic;

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String researchTopic) {
        super(rollNumber, name, CGPA);
        this.researchTopic = researchTopic;
    }

    public void displayResearchDetails() {
        System.out.println("Postgraduate Student Details:");
        displayStudentDetails();  // Accessing protected name via inherited method
        System.out.println("Research Topic: " + researchTopic);
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Create a Student object
        Student student1 = new Student(101, "Alice", 3.8);
        student1.displayStudentDetails();
        System.out.println();

        // Modify CGPA
        student1.setCGPA(3.9);
        System.out.println("Updated CGPA: " + student1.getCGPA());
        System.out.println();

        // Create a PostgraduateStudent object
        PostgraduateStudent pgStudent = new PostgraduateStudent(102, "Bob", 3.7, "Artificial Intelligence");
        pgStudent.displayResearchDetails();
    }
}
