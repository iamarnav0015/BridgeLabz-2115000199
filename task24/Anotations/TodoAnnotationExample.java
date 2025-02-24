
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class ProjectTasks {
    @Todo(task = "Implement login feature", assignedTo = "Alice", priority = "HIGH")
    public void loginFeature() {
        System.out.println("Login feature pending implementation...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDatabase() {
        System.out.println("Database optimization pending...");
    }

    public void completedTask() {
        System.out.println("This task is already completed.");
    }
}

public class TodoAnnotationExample {
    public static void main(String[] args) {
        try {
            Method[] methods = ProjectTasks.class.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Todo.class)) {
                    Todo annotation = method.getAnnotation(Todo.class);
                    System.out.println("Task: " + annotation.task());
                    System.out.println("Assigned To: " + annotation.assignedTo());
                    System.out.println("Priority: " + annotation.priority());
                    System.out.println("--------------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

