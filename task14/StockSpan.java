import java.util.Stack;

public class StockSpan {
    public static void calculateSpan(int[] prices, int n, int[] span) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        span[0] = 1;
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int n = prices.length;
        int[] span = new int[n];
        calculateSpan(prices, n, span);
        for (int i = 0; i < n; i++) {
            System.out.println(span[i]);
        }
    }
}
