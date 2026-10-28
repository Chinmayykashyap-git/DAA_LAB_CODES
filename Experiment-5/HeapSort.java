import java.util.Scanner;

public class HeapSort {

    /**
     * Maintains the max-heap property for a subtree rooted at index i.
     * n is the size of the heap.
     * Time Complexity: O(log n)
     */
    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    /**
     * Sorts an array using Heap Sort.
     * Time Complexity: O(n log n) in best, worst, and average cases.
     * Space Complexity: O(1) in-place auxiliary space.
     */
    static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build max heap (rearrange array)
        // Start from last non-leaf node down to root
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root (maximum element) to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        if (n > 0) {
            System.out.println("Enter elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            heapSort(arr);
        }

        System.out.println("Sorted array using Heap Sort:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

        sc.close();
    }
}
