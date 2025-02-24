
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }
}

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

class Student {
    private String name;

    public Student() {
        this.name = "Default Name";
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class ReflectionDemo5 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();
            scanner.close();

            // Create an instance of MathOperations
            MathOperations mathOperations = new MathOperations();

            // Get the Class object for MathOperations
            Class<?> mathClass = mathOperations.getClass();

            // Access the method dynamically
            Method method = mathClass.getDeclaredMethod(methodName, int.class, int.class);

            // Invoke the method
            int result = (int) method.invoke(mathOperations, 10, 5);

            // Print the result
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



