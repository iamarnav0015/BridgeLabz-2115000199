import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;

public class ReadJsonFile {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("data.json"));
            
            Iterator<String> fieldNames = jsonNode.fieldNames();
            while (fieldNames.hasNext()) {
                String field = fieldNames.next();
                System.out.println(field + ": " + jsonNode.get(field));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
