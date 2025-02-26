import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;
import java.io.File;

public class ValidateJsonExample {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode schemaNode = objectMapper.readTree(new File("schema.json"));
        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonSchema schema = factory.getJsonSchema(schemaNode);
        JsonNode jsonData = objectMapper.readTree(new File("user.json"));
        JsonValidator validator = factory.getValidator();
        boolean isValid = validator.validate(schema, jsonData).isSuccess();
        System.out.println(isValid ? "Valid JSON" : "Invalid JSON");
    }
}
