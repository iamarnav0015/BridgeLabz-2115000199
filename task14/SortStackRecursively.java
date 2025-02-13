import java.util.Stack;

public class SortStackRecursively {
    public static void sort(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int value = stack.pop();
            sort(stack);
            insert(stack, value);
        }
    }

    private static void insert(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }
        int temp = stack.pop();
        insert(stack, value);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        sort(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
