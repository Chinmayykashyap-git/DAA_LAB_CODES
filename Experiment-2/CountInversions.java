import java.util.Scanner;

public class CountInversions {

    /**
     * Merges two sorted halves and counts cross-inversions.
     */
    static long mergeAndCount(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;
        long inversions = 0;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                // All remaining elements in left half arr[i...mid] form inversions with arr[j]
                inversions += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        for (i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }

        return inversions;
    }

    /**
     * Modified Merge Sort to count inversions.
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    static long mergeSortAndCount(int[] arr, int low, int high) {
        if (low >= high)
            return 0;

        int mid = low + (high - low) / 2;
        long count = 0;

        count += mergeSortAndCount(arr, low, mid);
        count += mergeSortAndCount(arr, mid + 1, high);
        count += mergeAndCount(arr, low, mid, high);

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        if (n > 0) {
            System.out.println("Enter elements:");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }

        long inversions = (n > 1) ? mergeSortAndCount(arr, 0, n - 1) : 0;

        System.out.println("Number of inversions: " + inversions);

        sc.close();
    }
}
