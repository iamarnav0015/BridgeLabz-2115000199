public class ReflectionJsonDemo {
}

import java.lang.reflect.Field;

class JsonConverter {
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");
        try {
            Class<?> clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                Object value = fields[i].get(obj);
                json.append("\"" + fields[i].getName() + "\": ");

                if (value instanceof String) {
                    json.append("\"" + value + "\"");
                } else {
                    json.append(value);
                }

                if (i < fields.length - 1) {
                    json.append(", ");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error converting object to JSON", e);
        }
        json.append("}");
        return json.toString();
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ReflectionJsonDemo {
    public static void main(String[] args) {
        Person person = new Person("John Doe", 30);
        String json = JsonConverter.toJson(person);
        System.out.println("JSON Representation: " + json);
    }
}



