import java.util.ArrayList;
import java.util.List;

// University class (Composition with Departments)
class University {
    private String name;
    private List<Department> departments;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    // Add a department to the university
    public void addDepartment(Department department) {
        departments.add(department);
        System.out.println("Department " + department.getName() + " added to " + name);
    }

    // Remove all departments (Composition relationship)
    public void deleteUniversity() {
        System.out.println("Deleting University: " + name);
        departments.clear();
    }

    public String getName() {
        return name;
    }

    public List<Department> getDepartments() {
        return departments;
    }
}

// Department class (Dependent on University)
class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Faculty class (Aggregation relationship with University)
class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void teach() {
        System.out.println(name + " is teaching.");
    }
}

// Main class for testing
public class UniversityManagement {
    public static void main(String[] args) {
        // Create university
        University university = new University("ABC University");

        // Create departments (composition)
        Department csDepartment = new Department("Computer Science");
        Department mathDepartment = new Department("Mathematics");

        university.addDepartment(csDepartment);
        university.addDepartment(mathDepartment);

        // Create faculty members (aggregation)
        Faculty profJohn = new Faculty("Prof. John");
        Faculty profJane = new Faculty("Prof. Jane");

        System.out.println(profJohn.getName() + " and " + profJane.getName() + " are associated with " + university.getName() + ", but they exist independently.");

        // Faculty teaches independently of any department
        profJohn.teach();
        profJane.teach();

        // Deleting the university removes all departments
        university.deleteUniversity();

        // Verify departments are deleted
        System.out.println("Remaining Departments: " + university.getDepartments().size());
    }
}
