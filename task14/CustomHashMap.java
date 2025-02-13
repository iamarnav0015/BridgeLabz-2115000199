import java.util.LinkedList;

public class CustomHashMap {
    private static class Entry {
        int key, value;
        Entry(int key, int value) { this.key = key; this.value = value; }
    }

    private LinkedList<Entry>[] buckets;
    private int capacity = 10;

    public CustomHashMap() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int index = key % capacity;
        for (Entry entry : buckets[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        buckets[index].add(new Entry(key, value));
    }

    public Integer get(int key) {
        int index = key % capacity;
        for (Entry entry : buckets[index]) {
            if (entry.key == key) return entry.value;
        }
        return null;
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put(1, 10);
        System.out.println(map.get(1));
    }
}
