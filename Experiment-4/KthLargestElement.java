import java.util.Random;
import java.util.Scanner;

public class KthLargestElement {

    private static final Random rand = new Random();

    /**
     * Swaps elements at index i and j in array arr.
     */
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 3-Way Quickselect to find element at index targetIdx (0-based in sorted order).
     * 3-way partitioning cleanly handles arrays with many duplicate values.
     * Average Time Complexity: O(n)
     * Worst Time Complexity: O(n^2) (mitigated by randomized pivot)
     * Space Complexity: O(1) auxiliary (tail recursive/iterative)
     */
    static int quickSelect(int[] arr, int left, int right, int targetIdx) {
        while (left <= right) {
            if (left == right) {
                return arr[left];
            }

            // Randomized pivot selection
            int pivotIndex = left + rand.nextInt(right - left + 1);
            int pivotValue = arr[pivotIndex];

            // 3-way partition: elements < pivot, == pivot, > pivot
            int lt = left;
            int gt = right;
            int i = left;

            while (i <= gt) {
                if (arr[i] < pivotValue) {
                    swap(arr, lt++, i++);
                } else if (arr[i] > pivotValue) {
                    swap(arr, i, gt--);
                } else {
                    i++;
                }
            }

            // Range [lt, gt] contains all elements equal to pivotValue
            if (targetIdx >= lt && targetIdx <= gt) {
                return arr[targetIdx];
            } else if (targetIdx < lt) {
                right = lt - 1;
            } else {
                left = gt + 1;
            }
        }
        return -1;
    }

    /**
     * Finds the K-th largest element in an unsorted array.
     * The k-th largest element is at index (n - k) in 0-indexed ascending sorted order.
     */
    static int findKthLargest(int[] arr, int k) {
        int n = arr.length;
        if (k < 1 || k > n) {
            throw new IllegalArgumentException("k must be between 1 and " + n);
        }
        int targetIdx = n - k;
        return quickSelect(arr, 0, n - 1, targetIdx);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter K: ");
        int k = sc.nextInt();

        if (k < 1 || k > n) {
            System.out.println("Invalid K! K must be between 1 and " + n + ".");
        } else {
            int result = findKthLargest(arr, k);
            System.out.println(k + "-th Largest Element using Quickselect: " + result);
        }

        sc.close();
    }
}
