import java.util.Arrays;
import java.util.Random;

public class SortingComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000}; // Different dataset sizes
        Random random = new Random();

        for (int size : sizes) {
            int[] data = new int[size];

            // Fill array with random numbers
            for (int i = 0; i < size; i++) {
                data[i] = random.nextInt(size * 10);
            }

            System.out.println("Dataset Size: " + size);

            // Measure Bubble Sort time (skip for large data)
            if (size <= 10000) {
                int[] bubbleData = Arrays.copyOf(data, data.length);
                long startTime = System.nanoTime();
                bubbleSort(bubbleData);
                long bubbleTime = System.nanoTime() - startTime;
                System.out.println("Bubble Sort Time: " + (bubbleTime / 1_000_000.0) + " ms");
            } else {
                System.out.println("Bubble Sort Time: Unfeasible (>1hr)");
            }

            // Measure Merge Sort time
            int[] mergeData = Arrays.copyOf(data, data.length);
            long startTime = System.nanoTime();
            mergeSort(mergeData, 0, mergeData.length - 1);
            long mergeTime = System.nanoTime() - startTime;
            System.out.println("Merge Sort Time: " + (mergeTime / 1_000_000.0) + " ms");

            // Measure Quick Sort time
            int[] quickData = Arrays.copyOf(data, data.length);
            startTime = System.nanoTime();
            quickSort(quickData, 0, quickData.length - 1);
            long quickTime = System.nanoTime() - startTime;
            System.out.println("Quick Sort Time: " + (quickTime / 1_000_000.0) + " ms");
            System.out.println("-----------------------------------");
        }
    }

    // Bubble Sort (O(N^2))
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort (O(N log N))
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    // Quick Sort (O(N log N))
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}