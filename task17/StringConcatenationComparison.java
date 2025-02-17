public class StringConcatenationComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000}; // Different operation counts
        for (int size : sizes) {
            System.out.println("Operations Count: " + size);

            // Using String (O(N²))
            long startTime = System.nanoTime();
            stringConcatenation(size);
            long timeTaken = System.nanoTime() - startTime;
            System.out.println("String Time: " + (timeTaken / 1_000_000.0) + " ms");

            // Using StringBuilder (O(N))
            startTime = System.nanoTime();
            stringBuilderConcatenation(size);
            timeTaken = System.nanoTime() - startTime;
            System.out.println("StringBuilder Time: " + (timeTaken / 1_000_000.0) + " ms");

            // Using StringBuffer (O(N))
            startTime = System.nanoTime();
            stringBufferConcatenation(size);
            timeTaken = System.nanoTime() - startTime;
            System.out.println("StringBuffer Time: " + (timeTaken / 1_000_000.0) + " ms");

            System.out.println("-----------------------------------");
        }
    }

    // String concatenation (O(N²))
    public static void stringConcatenation(int n) {
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "a"; // Creates a new object each time (very slow for large N)
        }
    }

    // StringBuilder concatenation (O(N))
    public static void stringBuilderConcatenation(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
    }

    // StringBuffer concatenation (O(N))
    public static void stringBufferConcatenation(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
    }
}