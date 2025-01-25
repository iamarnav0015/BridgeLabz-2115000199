import java.util.Scanner;
public class eligible {
    public static void main(String[] args) {
        int[] ages = new int[10];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ages of 10 students:");
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            ages[i] = scanner.nextInt();
        }
        for (int age : ages) {
            if (age < 0) {
                System.out.println("Invalid age: " + age);
            } else if (age >= 18) {
                System.out.println("The student with the age " + age + " can vote.");
            } else {
                System.out.println("The student with the age " + age + " cannot vote.");
            }
        }
    }
}
