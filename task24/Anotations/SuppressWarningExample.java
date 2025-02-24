
import java.util.ArrayList;
import java.util.List;

public class SuppressWarningExample {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List rawList = new ArrayList(); // No generics used
        rawList.add("Hello");
        rawList.add("World");

        for (Object obj : rawList) {
            System.out.println(obj);
        }
    }
}



