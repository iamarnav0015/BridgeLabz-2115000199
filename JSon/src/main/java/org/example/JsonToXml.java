import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;

public class JsonToXml {
    public static void main(String[] args) {
        try {
            ObjectMapper jsonMapper = new ObjectMapper();
            JsonNode jsonNode = jsonMapper.readTree(new File("data.json"));

            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(jsonNode);

            System.out.println(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
