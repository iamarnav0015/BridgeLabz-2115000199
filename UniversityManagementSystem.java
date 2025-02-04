class Student {
    private static String universityName = "Global Tech University";
    private static int totalStudents = 0;

    private String name;
    private final int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
        System.out.println("Student added: " + name + " (Roll Number: " + rollNumber + ", Grade: " + grade + ")");
    }
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }
    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade);
        } else {
            System.out.println("Invalid student object.");
        }
    }
    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated for " + name + " to: " + newGrade);
        } else {
            System.out.println("Invalid student object. Grade update failed.");
        }
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Student.displayTotalStudents();
        Student student1 = new Student("Arnav", 101, "A");
        Student student2 = new Student("Tusharika", 102, "B");
        student1.displayStudentDetails();
        student2.displayStudentDetails();
        student1.updateGrade("A+");
        student2.updateGrade("B+");
        student1.displayStudentDetails();
        student2.displayStudentDetails();
        Student.displayTotalStudents();
    }
}
