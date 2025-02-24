
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod {
    String level() default "HIGH";
}

class TaskProcessor {
    @ImportantMethod(level = "HIGH")
    public void criticalTask() {
        System.out.println("Executing critical task...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void importantTask() {
        System.out.println("Executing important task...");
    }

    public void regularTask() {
        System.out.println("Executing regular task...");
    }
}

public class AnnotationExample {
    public static void main(String[] args) {
        try {
            Method[] methods = TaskProcessor.class.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(ImportantMethod.class)) {
                    ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                    System.out.println("Method: " + method.getName() + " | Importance Level: " + annotation.level());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

