import java.util.Random;

public class ZaraBonusCalculator {

    // Method to generate random salary and years of service for 10 employees
    public static double[][] generateEmployeeData(int size) {
        Random rand = new Random();
        double[][] employeeData = new double[size][2]; // 2D Array to store salary and years of service

        for (int i = 0; i < size; i++) {
            // Random salary between 10000 and 99999
            employeeData[i][0] = 10000 + rand.nextInt(90000);
            // Random years of service between 1 and 20
            employeeData[i][1] = 1 + rand.nextInt(20);
        }
        return employeeData;
    }

    // Method to calculate the new salary and bonus for each employee
    public static double[][] calculateBonusAndNewSalary(double[][] employeeData) {
        double[][] updatedData = new double[employeeData.length][3]; // [Old Salary, New Salary, Bonus]
        double bonusPercentage;

        for (int i = 0; i < employeeData.length; i++) {
            double oldSalary = employeeData[i][0];
            int yearsOfService = (int) employeeData[i][1];

            // Determine bonus percentage based on years of service
            if (yearsOfService > 5) {
                bonusPercentage = 0.05; // 5% bonus
            } else {
                bonusPercentage = 0.02; // 2% bonus
            }

            // Calculate bonus and new salary
            double bonus = oldSalary * bonusPercentage;
            double newSalary = oldSalary + bonus;

            updatedData[i][0] = oldSalary; // Store old salary
            updatedData[i][1] = newSalary; // Store new salary
            updatedData[i][2] = bonus; // Store bonus
        }
        return updatedData;
    }

    // Method to calculate and display total salary and bonuses in a tabular format
    public static void displayResults(double[][] updatedData) {
        double totalOldSalary = 0, totalNewSalary = 0, totalBonus = 0;

        // Print header for the table
        System.out.println("----------------------------------------------------");
        System.out.printf("%-15s %-15s %-15s %-15s%n", "Employee", "Old Salary", "New Salary", "Bonus");
        System.out.println("----------------------------------------------------");

        // Display employee data and calculate totals
        for (int i = 0; i < updatedData.length; i++) {
            double oldSalary = updatedData[i][0];
            double newSalary = updatedData[i][1];
            double bonus = updatedData[i][2];

            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonus;

            System.out.printf("%-15d %-15.2f %-15.2f %-15.2f%n", i + 1, oldSalary, newSalary, bonus);
        }

        // Display totals
        System.out.println("----------------------------------------------------");
        System.out.printf("%-15s %-15.2f %-15.2f %-15.2f%n", "Total", totalOldSalary, totalNewSalary, totalBonus);
    }

    public static void main(String[] args) {
        int size = 10; // Number of employees

        // Generate employee data (salary and years of service)
        double[][] employeeData = generateEmployeeData(size);

        // Calculate the bonus and new salary for each employee
        double[][] updatedData = calculateBonusAndNewSalary(employeeData);

        // Display the results
        displayResults(updatedData);
    }
}
