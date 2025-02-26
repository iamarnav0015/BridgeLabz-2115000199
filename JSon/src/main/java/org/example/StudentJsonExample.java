import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Arrays;

public class StudentJsonExample {
    public static void main(String[] args) {
        JSONObject student = new JSONObject();
        student.put("name", "John");
        student.put("age", 22);
        JSONArray subjects = new JSONArray(Arrays.asList("Math", "Science", "History"));
        student.put("subjects", subjects);
        System.out.println(student.toString());
    }
}
