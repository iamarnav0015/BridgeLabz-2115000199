import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static int findLongestSequence(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int maxLength = 0;
        for (int value : arr) {
            set.add(value);
        }
        for (int value : arr) {
            if (!set.contains(value - 1)) {
                int current = value;
                int length = 1;
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(findLongestSequence(arr));
    }
}
