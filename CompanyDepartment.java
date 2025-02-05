import java.util.ArrayList;

public class CompanyDepartment{

    // Employee Class
    public static class Employee {
        private String name;
        private String position;

        // Constructor
        public Employee(String name, String position) {
            this.name = name;
            this.position = position;
        }

        // Method to display employee details
        public void displayEmployee() {
            System.out.println("Name: " + name + ", Position: " + position);
        }
    }

    // Department Class
    public static class Department {
        private String name;
        private ArrayList<Employee> employees;

        // Constructor
        public Department(String name) {
            this.name = name;
            this.employees = new ArrayList<>();
        }

        // Method to add an employee to the department
        public void addEmployee(Employee employee) {
            employees.add(employee);
        }

        // Method to display all employees in the department
        public void displayEmployees() {
            System.out.println("Department: " + name);
            for (Employee employee : employees) {
                employee.displayEmployee();
            }
        }
    }

    // Company Class
    public static class Company {
        private String name;
        private ArrayList<Department> departments;

        // Constructor
        public Company(String name) {
            this.name = name;
            this.departments = new ArrayList<>();
        }

        // Method to add a department to the company
        public void addDepartment(Department department) {
            departments.add(department);
        }

        // Method to display all departments and their employees
        public void displayDepartments() {
            System.out.println("Company: " + name);
            for (Department department : departments) {
                department.displayEmployees();
            }
        }

        // Destructor to demonstrate the deletion of all associated objects
        protected void finalize() throws Throwable {
            // Mimicking the removal of departments and employees
            System.out.println("Deleting Company and its Departments and Employees...");
            super.finalize();
        }
    }

    // Main method to demonstrate composition
    public static void main(String[] args) {
        // Creating employee objects
        Employee emp1 = new Employee("Ritesh", "Manager");
        Employee emp2 = new Employee("Akshay", "Developer");
        Employee emp3 = new Employee("Amir", "HR");

        // Creating department objects
        Department dept1 = new Department("IT");
        Department dept2 = new Department("HR");

        // Adding employees to departments
        dept1.addEmployee(emp1);
        dept1.addEmployee(emp2);
        dept2.addEmployee(emp3);

        // Creating company object
        Company company = new Company("TechCorp");

        // Adding departments to the company
        company.addDepartment(dept1);
        company.addDepartment(dept2);

        // Displaying company, departments, and employees
        company.displayDepartments();

        // Simulating company deletion (garbage collection will invoke finalize)
        company = null; // Set company to null to mimic "deletion"
        System.gc(); // Request garbage collection (in real scenarios, it is automatic)
    }
}
