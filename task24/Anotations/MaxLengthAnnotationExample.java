
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        if (!isValidLength(username)) {
            throw new IllegalArgumentException("Username exceeds maximum allowed length");
        }
        this.username = username;
    }

    private boolean isValidLength(String value) {
        try {
            Field field = this.getClass().getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                int maxLength = field.getAnnotation(MaxLength.class).value();
                return value.length() <= maxLength;
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return true;
    }

    public String getUsername() {
        return username;
    }
}

public class MaxLengthAnnotationExample {
    public static void main(String[] args) {
        try {
            User user1 = new User("ShortName");
            System.out.println("Valid Username: " + user1.getUsername());

            User user2 = new User("ThisNameIsTooLong"); // This should throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

