import java.util.Scanner;

public class BMI_Calculator {

    public static double calculateBMI(double weight, double height) {
        height = height / 100; // Convert height from cm to meters
        return weight / (height * height); // BMI formula
    }

    public static String determineBMIStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi >= 18.5 && bmi <= 24.9) return "Normal weight";
        else if (bmi >= 25 && bmi <= 29.9) return "Overweight";
        else return "Obese";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] personData = new double[10][3]; // 10 persons, 3 columns (weight, height, BMI)

        // Taking user input for weight and height, and calculating BMI
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            personData[i][0] = scanner.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            personData[i][1] = scanner.nextDouble();

            // Calculate BMI and store in the third column
            personData[i][2] = calculateBMI(personData[i][0], personData[i][1]);
        }

        // Displaying the result
        System.out.println("\nPerson No | Weight (kg) | Height (cm) | BMI     | Status");
        for (int i = 0; i < 10; i++) {
            String status = determineBMIStatus(personData[i][2]);
            System.out.printf("%-10d| %-12.2f| %-12.2f| %-7.2f| %s%n", i + 1, personData[i][0], personData[i][1], personData[i][2], status);
        }
    }
}

