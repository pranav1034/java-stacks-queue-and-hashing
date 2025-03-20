import java.util.LinkedList;
import java.util.Objects;

public class ImplementHashMap<K, V> {

    // Node class represents a key-value pair stored in the hash map.
    private class Node {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Array of linked lists to store nodes (buckets)
    private LinkedList<Node>[] buckets;
    private int capacity;  // Number of buckets
    private int size;      // Number of key-value pairs stored

    // Default constructor with a default capacity
    public ImplementHashMap() {
        this(16);
    }

    // Constructor to specify a custom capacity
    public ImplementHashMap(int capacity) {
        this.capacity = capacity;
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    // Helper method to compute the bucket index for a given key.
    private int getBucketIndex(K key) {
        int hashCode = (key == null) ? 0 : key.hashCode();
        // Ensure a positive index
        return Math.abs(hashCode) % capacity;
    }

    // Insertion: adds a new key-value pair or updates the value if the key already exists.
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<Node> bucket = buckets[index];

        // Check if the key already exists in the bucket.
        for (Node node : bucket) {
            if (Objects.equals(node.key, key)) {
                // Key exists: update the value.
                node.value = value;
                return;
            }
        }

        // Key does not exist: add a new node to the bucket.
        bucket.add(new Node(key, value));
        size++;
    }

    // Retrieval: returns the value associated with the key, or null if the key is not found.
    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Node> bucket = buckets[index];

        for (Node node : bucket) {
            if (Objects.equals(node.key, key)) {
                return node.value;
            }
        }
        return null;
    }

    // Deletion: removes the key-value pair and returns its value, or null if the key is not found.
    public V remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Node> bucket = buckets[index];

        for (Node node : bucket) {
            if (Objects.equals(node.key, key)) {
                V value = node.value;
                bucket.remove(node);
                size--;
                return value;
            }
        }
        return null;
    }

    // Returns the number of key-value pairs in the hash map.
    public int size() {
        return size;
    }

    // A simple test of the CustomHashMap.
    public static void main(String[] args) {
        ImplementHashMap<String, Integer> map = new ImplementHashMap<>();

        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println("Size: " + map.size());              // Should print: 3
        System.out.println("Value for 'two': " + map.get("two"));  // Should print: 2

        map.put("two", 22); // Updating the value for key "two"
        System.out.println("Updated value for 'two': " + map.get("two")); // Should print: 22

        map.remove("three");
        System.out.println("Size after removing 'three': " + map.size()); // Should print: 2
    }
}
