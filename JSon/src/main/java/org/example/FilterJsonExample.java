import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilterJsonExample {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonArray = objectMapper.readTree(new File("users.json"));

        List<JsonNode> filteredUsers = new ArrayList<>();
        for (JsonNode node : jsonArray) {
            if (node.get("age").asInt() > 25) {
                filteredUsers.add(node);
            }
        }

        System.out.println(objectMapper.writeValueAsString(filteredUsers));
    }
}
