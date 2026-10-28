import java.util.Arrays;
import java.util.Scanner;

public class MedianOfMedians {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Finds the median of a small subarray arr[l...r] by simple sorting.
     */
    static int findMedianOfSubarray(int[] arr, int l, int r) {
        Arrays.sort(arr, l, r + 1);
        return arr[l + (r - l) / 2];
    }

    /**
     * Median of Medians algorithm to find a good pivot in worst-case O(n) time.
     */
    static int getMedianOfMedians(int[] arr, int l, int r) {
        int n = r - l + 1;
        if (n <= 5) {
            return findMedianOfSubarray(arr, l, r);
        }

        // Divide arr into groups of 5, find median of each, and gather at front
        int numGroups = (n + 4) / 5;
        int[] medians = new int[numGroups];

        for (int i = 0; i < numGroups; i++) {
            int subL = l + i * 5;
            int subR = Math.min(subL + 4, r);
            medians[i] = findMedianOfSubarray(arr, subL, subR);
        }

        // Recursively find median of the medians
        return selectKth(medians, 0, numGroups - 1, numGroups / 2);
    }

    /**
     * BFPRT (Median of Medians) deterministic selection algorithm.
     * Finds the element that would appear at targetIdx (0-indexed) in sorted array.
     * Guaranteed Worst-Case Time Complexity: O(n)
     * Space Complexity: O(log n) call stack
     */
    static int selectKth(int[] arr, int l, int r, int targetIdx) {
        if (l == r) {
            return arr[l];
        }

        // Get guaranteed good pivot using Median of Medians
        int pivot = getMedianOfMedians(arr, l, r);

        // 3-way partition around pivot: < pivot, == pivot, > pivot
        // This handles duplicates efficiently without infinite recursion
        int lt = l;
        int gt = r;
        int i = l;

        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, lt++, i++);
            } else if (arr[i] > pivot) {
                swap(arr, i, gt--);
            } else {
                i++;
            }
        }

        // Check which partition contains the targetIdx
        if (targetIdx >= lt && targetIdx <= gt) {
            return arr[targetIdx];
        } else if (targetIdx < lt) {
            return selectKth(arr, l, lt - 1, targetIdx);
        } else {
            return selectKth(arr, gt + 1, r, targetIdx);
        }
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

        System.out.print("Enter K (to find K-th smallest element, 1 to " + n + "): ");
        int k = sc.nextInt();

        if (k < 1 || k > n) {
            System.out.println("Invalid K! Must be between 1 and " + n + ".");
        } else {
            // k-th smallest is at index k-1 in sorted order
            int kthSmallest = selectKth(arr, 0, n - 1, k - 1);
            System.out.println(k + "-th Smallest Element using Median of Medians: " + kthSmallest);
        }

        sc.close();
    }
}
