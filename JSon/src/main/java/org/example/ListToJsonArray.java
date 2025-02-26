import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.Arrays;
import java.util.List;

class Employee {
    public String name;
    public int age;
    public String department;

    public Employee(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }
}

public class ListToJsonArray {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30, "HR"),
                new Employee("Bob", 28, "IT"),
                new Employee("Charlie", 35, "Finance")
            );

            String jsonArray = objectMapper.writeValueAsString(employees);
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
