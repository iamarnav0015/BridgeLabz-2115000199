
import java.lang.reflect.Field;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }
}

public class ReflectionDemo2 {
    public static void main(String[] args) {
        try {
            // Create an instance of Person
            Person person = new Person(25);

            // Get the Class object
            Class<?> cls = person.getClass();

            // Access the private field "age"
            Field ageField = cls.getDeclaredField("age");
            ageField.setAccessible(true);

            // Retrieve and print the original value
            System.out.println("Original Age: " + ageField.get(person));

            // Modify the private field "age"
            ageField.set(person, 30);

            // Retrieve and print the modified value
            System.out.println("Modified Age: " + ageField.get(person));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

