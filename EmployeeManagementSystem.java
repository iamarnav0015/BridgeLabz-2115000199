class Employee {
    private static String companyName = "Tech Solutions Inc.";
    private static int totalEmployees = 0;

    private String name;
    private String designation;
    private final int id;
    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
        System.out.println("Employee added: " + name + " (ID: " + id + ", Designation: " + designation + ")");
    }
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
    public void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Designation: " + designation);
        } else {
            System.out.println("Invalid employee object.");
        }
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee.displayTotalEmployees();
        Employee emp1 = new Employee("Alice", 101, "Software Engineer");
        Employee emp2 = new Employee("Bob", 102, "Project Manager");
        emp1.displayEmployeeDetails();
        emp2.displayEmployeeDetails();
        Employee.displayTotalEmployees();
    }
}
