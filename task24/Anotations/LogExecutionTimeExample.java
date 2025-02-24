
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {}

class ExecutionTimer {
    public static void measureExecutionTime(Object obj, String methodName, Class<?>... paramTypes) {
        try {
            Method method = obj.getClass().getDeclaredMethod(methodName, paramTypes);
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(obj);
                long endTime = System.nanoTime();
                System.out.println("Execution time of " + methodName + ": " + (endTime - startTime) / 1_000_000.0 + " milliseconds");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error measuring execution time for method: " + methodName, e);
        }
    }
}

class TaskProcessor2 {
    @LogExecutionTime
    public void fastTask() {
        System.out.println("Fast task executed");
    }

    @LogExecutionTime
    public void slowTask() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Slow task executed");
    }
}

public class LogExecutionTimeExample {
    public static void main(String[] args) {
        TaskProcessor2 processor = new TaskProcessor2();

        ExecutionTimer.measureExecutionTime(processor, "fastTask");
        ExecutionTimer.measureExecutionTime(processor, "slowTask");
    }
}



