
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "John Doe")
class DocumentedClass {
    public void display() {
        System.out.println("This is a documented class.");
    }
}

class Person {
    private int age;

    public Person() {}

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

class Student {
    private String name;

    public Student() {}

    public void setName(String name) {
        this.name = name;
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

class Configuration {
    private static String API_KEY = "DEFAULT_KEY";

    public static void printApiKey() {
        System.out.println("API_KEY: " + API_KEY);
    }
}

class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                Field field = clazz.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(instance, entry.getValue());
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping properties to object", e);
        }
    }
}

public class ReflectionDemo8 {
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

            // Retrieve annotation at runtime
            Class<?> documentedClass = DocumentedClass.class;
            if (documentedClass.isAnnotationPresent(Author.class)) {
                Author author = documentedClass.getAnnotation(Author.class);
                System.out.println("Class is authored by: " + author.name());
            }

            // Access and modify static field API_KEY
            Class<?> configClass = Configuration.class;
            Field apiKeyField = configClass.getDeclaredField("API_KEY");
            apiKeyField.setAccessible(true);

            // Modify API_KEY value
            apiKeyField.set(null, "NEW_API_KEY");

            // Print updated API_KEY
            Configuration.printApiKey();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

