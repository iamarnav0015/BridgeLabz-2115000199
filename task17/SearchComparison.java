import java.util.Arrays;
import java.util.Random;

public class SearchComparison {

    // Linear Search Implementation (O(N))
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random rand = new Random();

        System.out.printf("%-15s %-20s %-20s\n", "Dataset Size", "Linear Search (ms)", "Binary Search (ms)");
        System.out.println("------------------------------------------------------");

        for (int size : sizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = i; // Sorted data
            }
            int target = rand.nextInt(size);

            // Measure Linear Search Time
            long startTime = System.nanoTime();
            linearSearch(data, target);
            long linearTime = System.nanoTime() - startTime;

            // Measure Binary Search Time using built-in function
            startTime = System.nanoTime();
            Arrays.binarySearch(data, target);
            long binaryTime = System.nanoTime() - startTime;

            System.out.printf("%-15d %-20.6f %-20.6f\n", size, linearTime / 1e6, binaryTime / 1e6);
        }
    }
}