
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

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

public class ReflectionDemo4 {
    public static void main(String[] args) {
        try {
            // Create an instance of Person
            Person person = new Person(25);

            // Get the Class object for Person
            Class<?> personClass = person.getClass();

            // Access the private field "age"
            Field ageField = personClass.getDeclaredField("age");
            ageField.setAccessible(true);

            // Retrieve and print the original value
            System.out.println("Original Age: " + ageField.get(person));

            // Modify the private field "age"
            ageField.set(person, 30);

            // Retrieve and print the modified value
            System.out.println("Modified Age: " + ageField.get(person));

            // Create an instance of Calculator
            Calculator calculator = new Calculator();

            // Get the Class object for Calculator
            Class<?> calculatorClass = calculator.getClass();

            // Access the private method "multiply"
            Method multiplyMethod = calculatorClass.getDeclaredMethod("multiply", int.class, int.class);
            multiplyMethod.setAccessible(true);

            // Invoke the private method
            int result = (int) multiplyMethod.invoke(calculator, 5, 10);

            // Print the result
            System.out.println("Result of multiply method: " + result);

            // Dynamically create an instance of Student
            Class<?> studentClass = Class.forName("Student");
            Constructor<?> studentConstructor = studentClass.getDeclaredConstructor();
            Object studentInstance = studentConstructor.newInstance();

            // Invoke the display method
            Method displayMethod = studentClass.getDeclaredMethod("display");
            displayMethod.invoke(studentInstance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

