import java.util.*;

public class DataStructureSearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000}; // Different dataset sizes
        Random rand = new Random();

        System.out.println("N | Array Search (ms) | HashSet Search (ms) | TreeSet Search (ms)");
        System.out.println("---------------------------------------------------------------");

        for (int size : sizes) {
            System.out.println("Testing with N = " + size);

            // Prepare dataset
            int[] array = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < size; i++) {
                array[i] = i; // Sorted data
                hashSet.add(i);
                treeSet.add(i);
            }

            int target = rand.nextInt(size); // Random search target

            // Measure Array Search Time (Linear Search)
            long startTime = System.nanoTime();
            linearSearch(array, target);
            long arrayTime = (System.nanoTime() - startTime) / 1_000_000; // Convert to ms

            // Measure HashSet Search Time
            startTime = System.nanoTime();
            hashSet.contains(target);
            long hashSetTime = (System.nanoTime() - startTime) / 1_000_000; // Convert to ms

            // Measure TreeSet Search Time
            startTime = System.nanoTime();
            treeSet.contains(target);
            long treeSetTime = (System.nanoTime() - startTime) / 1_000_000; // Convert to ms

            System.out.println(size + " | " + arrayTime + " ms | " + hashSetTime + " ms | " + treeSetTime + " ms");
            System.out.println("---------------------------------------------------------------");
        }
    }

    // Linear Search (O(N))
    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
