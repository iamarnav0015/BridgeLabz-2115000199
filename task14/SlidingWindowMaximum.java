import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void findMax(int[] arr, int n, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peek() == i - k) {
                deque.poll();
            }
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                System.out.println(arr[deque.peek()]);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        findMax(arr, arr.length, k);
    }
}
