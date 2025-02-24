
import java.lang.reflect.Method;

class MethodTimer {
    public static void measureExecutionTime(Object obj, String methodName, Class<?>... paramTypes) {
        try {
            Method method = obj.getClass().getDeclaredMethod(methodName, paramTypes);
            method.setAccessible(true);
            long startTime = System.nanoTime();
            method.invoke(obj);
            long endTime = System.nanoTime();
            System.out.println("Execution time of " + methodName + ": " + (endTime - startTime) / 1_000_000.0 + " milliseconds");
        } catch (Exception e) {
            throw new RuntimeException("Error measuring execution time for method: " + methodName, e);
        }
    }
}

class ExampleClass {
    public void fastMethod() {
        System.out.println("Fast method executed");
    }

    public void slowMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Slow method executed");
    }
}

public class ReflectionTimingDemo {
    public static void main(String[] args) {
        ExampleClass example = new ExampleClass();

        MethodTimer.measureExecutionTime(example, "fastMethod");
        MethodTimer.measureExecutionTime(example, "slowMethod");
    }
}



