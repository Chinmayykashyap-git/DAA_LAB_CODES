import java.util.Scanner;

public class HashTableImplementation {

    // Node for Separate Chaining
    static class HashNode {
        int key;
        String value;
        HashNode next;

        HashNode(int key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private HashNode[] table;
    private int capacity;
    private int size;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;

    public HashTableImplementation(int initialCapacity) {
        this.capacity = initialCapacity;
        this.table = new HashNode[capacity];
        this.size = 0;
    }

    private int hashFunction(int key) {
        // Handle potential negative keys cleanly
        int hash = key % capacity;
        return (hash < 0) ? hash + capacity : hash;
    }

    /**
     * Resizes the hash table and rehashes all keys when load factor exceeds threshold.
     */
    private void rehash() {
        int oldCapacity = capacity;
        HashNode[] oldTable = table;

        capacity = oldCapacity * 2;
        table = new HashNode[capacity];
        size = 0;

        for (int i = 0; i < oldCapacity; i++) {
            HashNode curr = oldTable[i];
            while (curr != null) {
                insert(curr.key, curr.value);
                curr = curr.next;
            }
        }
    }

    /**
     * Inserts a key-value pair into the Hash Table.
     * Updates value if key already exists.
     */
    public void insert(int key, String value) {
        int index = hashFunction(key);
        HashNode head = table[index];

        // Check if key already exists
        HashNode curr = head;
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }

        // Insert new node at head of chain
        HashNode newNode = new HashNode(key, value);
        newNode.next = head;
        table[index] = newNode;
        size++;

        // Check load factor and rehash if necessary
        if ((1.0 * size) / capacity > LOAD_FACTOR_THRESHOLD) {
            rehash();
        }
    }

    /**
     * Searches for a key in the Hash Table.
     * Returns value if found, null otherwise.
     */
    public String search(int key) {
        int index = hashFunction(key);
        HashNode curr = table[index];
        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }
        return null;
    }

    /**
     * Deletes a key from the Hash Table.
     * Returns true if found and deleted, false otherwise.
     */
    public boolean delete(int key) {
        int index = hashFunction(key);
        HashNode curr = table[index];
        HashNode prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    table[index] = curr.next;
                }
                size--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    /**
     * Displays all buckets and chains of the Hash Table.
     */
    public void display() {
        System.out.println("\n--- Hash Table (Size: " + size + ", Capacity: " + capacity + ") ---");
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            HashNode curr = table[i];
            if (curr == null) {
                System.out.println("null");
            } else {
                while (curr != null) {
                    System.out.print("[" + curr.key + " -> " + curr.value + "] -> ");
                    curr = curr.next;
                }
                System.out.println("null");
            }
        }
        System.out.println("----------------------------------------------\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashTableImplementation ht = new HashTableImplementation(7);

        System.out.println("=== Hash Table with Separate Chaining ===");
        boolean running = true;

        while (running) {
            System.out.println("\n1. Insert (Key, Value)");
            System.out.println("2. Search by Key");
            System.out.println("3. Delete by Key");
            System.out.println("4. Display Hash Table");
            System.out.println("5. Exit");
            System.out.print("Choose option (1-5): ");

            if (!sc.hasNextInt()) break;
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter integer key: ");
                    int k = sc.nextInt();
                    System.out.print("Enter string value: ");
                    String v = sc.next();
                    ht.insert(k, v);
                    System.out.println("Inserted (" + k + ", " + v + ") successfully.");
                    break;
                case 2:
                    System.out.print("Enter key to search: ");
                    int sk = sc.nextInt();
                    String found = ht.search(sk);
                    if (found != null) {
                        System.out.println("Found! Key: " + sk + ", Value: " + found);
                    } else {
                        System.out.println("Key " + sk + " not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter key to delete: ");
                    int dk = sc.nextInt();
                    boolean del = ht.delete(dk);
                    if (del) {
                        System.out.println("Key " + dk + " deleted successfully.");
                    } else {
                        System.out.println("Key " + dk + " not found to delete.");
                    }
                    break;
                case 4:
                    ht.display();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }

        sc.close();
    }
}
