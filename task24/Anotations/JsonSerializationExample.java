
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_email")
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String toJson() {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = this.getClass().getDeclaredFields();

        try {
            for (Field field : fields) {
                if (field.isAnnotationPresent(JsonField.class)) {
                    field.setAccessible(true);
                    JsonField annotation = field.getAnnotation(JsonField.class);
                    json.append("\"" + annotation.name() + "\": \"" + field.get(this) + "\", ");
                }
            }
            if (json.length() > 1) {
                json.setLength(json.length() - 2); // Remove trailing comma
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        json.append("}");
        return json.toString();
    }
}

public class JsonSerializationExample {
    public static void main(String[] args) {
        User user = new User("Alice", "alice@example.com");
        System.out.println(user.toJson());
    }
}



