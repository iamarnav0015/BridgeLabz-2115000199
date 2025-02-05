import java.util.ArrayList;

public class StudentManagement {

    // Course Class
    public static class Course {
        private String name;
        private ArrayList<Student> students;

        // Constructor
        public Course(String name) {
            this.name = name;
            this.students = new ArrayList<>();
        }

        // Method to enroll a student in the course
        public void enrollStudent(Student student) {
            students.add(student);
        }

        // Method to display all students enrolled in the course
        public void displayStudents() {
            System.out.println("Course: " + name);
            for (Student student : students) {
                System.out.println(student.getName());
            }
        }
    }

    // Student Class
    public static class Student {
        private String name;
        private ArrayList<Course> courses;

        // Constructor
        public Student(String name) {
            this.name = name;
            this.courses = new ArrayList<>();
        }

        // Method to enroll in a course
        public void enrollInCourse(Course course) {
            courses.add(course);
            course.enrollStudent(this); // Enroll student in the course
        }

        // Getter for name
        public String getName() {
            return name;
        }

        // Method to display all courses a student is enrolled in
        public void displayCourses() {
            System.out.println(name + " is enrolled in the following courses:");
            for (Course course : courses) {
                System.out.println(course.name);
            }
        }
    }

    // School Class (Aggregation)
    public static class School {
        private String name;
        private ArrayList<Student> students;

        // Constructor
        public School(String name) {
            this.name = name;
            this.students = new ArrayList<>();
        }

        // Method to add a student to the school
        public void addStudent(Student student) {
            students.add(student);
        }

        // Method to display all students in the school
        public void displayStudents() {
            System.out.println("Students in " + name + " School:");
            for (Student student : students) {
                System.out.println(student.getName());
            }
        }
    }

    // Main method to demonstrate the relationships
    public static void main(String[] args) {
        // Creating student objects
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        Student student3 = new Student("Charlie");

        // Creating course objects
        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Physics");
        Course course3 = new Course("Computer Science");

        // Creating school object
        School school = new School("Greenwood High School");

        // Adding students to the school
        school.addStudent(student1);
        school.addStudent(student2);
        school.addStudent(student3);

        // Enrolling students in courses
        student1.enrollInCourse(course1);
        student1.enrollInCourse(course2);
        student2.enrollInCourse(course2);
        student2.enrollInCourse(course3);
        student3.enrollInCourse(course1);
        student3.enrollInCourse(course3);

        // Displaying students and their courses
        school.displayStudents();
        student1.displayCourses();
        student2.displayCourses();
        student3.displayCourses();

        // Displaying students enrolled in each course
        course1.displayStudents();
        course2.displayStudents();
        course3.displayStudents();
    }
}
