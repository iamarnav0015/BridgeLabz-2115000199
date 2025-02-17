public class FibonacciComparison {
    public static void main(String[] args) {
        int[] testCases = {10, 30, 50}; // Different Fibonacci values

        System.out.println("N | Recursive Time (ms) | Iterative Time (ms)");
        System.out.println("--------------------------------------------");

        for (int n : testCases) {
            System.out.println("Computing Fibonacci for N = " + n);

            // Measure Recursive Time
            long startTime = System.nanoTime();
            if (n <= 40) { // Prevent long execution for large N
                fibonacciRecursive(n);
            } else {
                System.out.println("Recursive approach skipped for N = " + n + " (too slow)");
            }
            long recursiveTime = (System.nanoTime() - startTime) / 1_000_000; // Convert to ms

            // Measure Iterative Time
            startTime = System.nanoTime();
            fibonacciIterative(n);
            long iterativeTime = (System.nanoTime() - startTime) / 1_000_000; // Convert to ms

            System.out.println(n + " | " + (n > 40 ? "Unfeasible" : recursiveTime + " ms") + " | " + iterativeTime + " ms");
            System.out.println("--------------------------------------------");
        }
    }

    // Recursive Fibonacci (O(2^N))
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (O(N))
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
