import java.util.*;

class CircularBuffer {
    private int[] buffer;
    private int size, start, end;

    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
        size = 0;
        start = 0;
        end = 0;
    }

    public void insert(int value) {
        buffer[end] = value;
        end = (end + 1) % buffer.length;
        if (size < buffer.length) {
            size++;
        } else {
            start = (start + 1) % buffer.length;
        }
    }

    public List<Integer> getBuffer() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(buffer[(start + i) % buffer.length]);
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.insert(4);
        System.out.println(buffer.getBuffer());
    }
}
