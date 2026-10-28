import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeKSortedArrays {

    static class ArrayEntry {
        int val;
        int arrayIdx;
        int elementIdx;

        ArrayEntry(int val, int arrayIdx, int elementIdx) {
            this.val = val;
            this.arrayIdx = arrayIdx;
            this.elementIdx = elementIdx;
        }
    }

    /**
     * Merges K sorted arrays into a single sorted array using a Min-Heap.
     * Time Complexity: O(N log K), where N is total number of elements across all K arrays
     * Space Complexity: O(K) for the priority queue
     */
    static List<Integer> mergeKSorted(int[][] arrays, int k) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Step 1: Insert the first element of each non-empty array into the Min-Heap
        for (int i = 0; i < k; i++) {
            if (arrays[i] != null && arrays[i].length > 0) {
                minHeap.offer(new ArrayEntry(arrays[i][0], i, 0));
            }
        }

        // Step 2: Repeatedly extract the minimum and push the next element from the same array
        while (!minHeap.isEmpty()) {
            ArrayEntry curr = minHeap.poll();
            result.add(curr.val);

            int nextElementIdx = curr.elementIdx + 1;
            if (nextElementIdx < arrays[curr.arrayIdx].length) {
                minHeap.offer(new ArrayEntry(arrays[curr.arrayIdx][nextElementIdx], curr.arrayIdx, nextElementIdx));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of sorted arrays (K): ");
        int k = sc.nextInt();

        int[][] arrays = new int[k][];
        for (int i = 0; i < k; i++) {
            System.out.print("Enter size of array " + (i + 1) + ": ");
            int size = sc.nextInt();
            arrays[i] = new int[size];
            if (size > 0) {
                System.out.println("Enter " + size + " sorted elements for array " + (i + 1) + ":");
                for (int j = 0; j < size; j++) {
                    arrays[i][j] = sc.nextInt();
                }
            }
        }

        List<Integer> merged = mergeKSorted(arrays, k);

        System.out.println("Merged Sorted Array:");
        for (int val : merged) {
            System.out.print(val + " ");
        }
        System.out.println();

        sc.close();
    }
}
