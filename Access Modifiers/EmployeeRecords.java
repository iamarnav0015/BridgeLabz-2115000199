// Base class: Employee
class Employee {
    public String employeeID;
    protected String department;
    private double salary;

    // Constructor to initialize employee details
    public Employee(String employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Method to modify salary
    public void modifySalary(double newSalary) {
        if (newSalary > 0) {
            salary = newSalary;
            System.out.println("Salary updated to $" + salary);
        } else {
            System.out.println("Invalid salary amount.");
        }
    }

    // Getter for salary
    public double getSalary() {
        return salary;
    }

    // Method to display employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}

// Subclass: Manager
class Manager extends Employee {

    public Manager(String employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    // Method to display manager details (inheriting from Employee)
    public void displayManagerDetails() {
        System.out.println("Manager Details:");
        System.out.println("Employee ID: " + employeeID); // Accessing public member from superclass
        System.out.println("Department: " + department); // Accessing protected member from superclass
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        // Create an Employee object
        Employee employee1 = new Employee("E123", "Sales", 50000.0);
        employee1.displayEmployeeDetails();
        employee1.modifySalary(55000.0);
        employee1.displayEmployeeDetails();
        System.out.println();

        // Create a Manager object (which is a subclass of Employee)
        Manager manager1 = new Manager("M001", "HR", 75000.0);
        manager1.displayManagerDetails();
        manager1.modifySalary(80000.0);
        manager1.displayEmployeeDetails();
    }
}
