import java.util.ArrayList;
import java.util.List;

// Abstract class representing a course type
abstract class CourseType {
    private String typeName;

    public CourseType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}

// Specific course types
class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based");
    }
}

class AssignmentCourse extends CourseType {


    public AssignmentCourse() {
        super("Assignment-Based");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based");
    }
}

// Generic Course class with bounded type parameter
class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return courseName + " (Type: " + courseType.getTypeName() + ")";
    }
}

// Utility class to display courses
class UniversityUtils {
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course);
        }

    }
}

// University class to manage courses
class University {
    private List<Course<?>> courses = new ArrayList<>();

    public void addCourse(Course<?> course) {
        courses.add(course);
    }

    public void displayCourses() {
        for (Course<?> course : courses) {
            System.out.println(course);
        }
    }
}

public class UniversityManagement {
    public static void main(String[] args) {
        University university = new University();

        Course<ExamCourse> math = new Course<>("Mathematics", new
                ExamCourse());
        Course<AssignmentCourse> literature = new Course<>("English
                Literature", new AssignmentCourse());
                Course<ResearchCourse> physics = new Course<>("Quantum Physics", new
                        ResearchCourse());

        university.addCourse(math);
        university.addCourse(literature);
        university.addCourse(physics);

        System.out.println("University Courses:");
        university.displayCourses();
    }
}