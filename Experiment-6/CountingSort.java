import java.util.Scanner;

public class CountingSort {

    /**
     * Stable Counting Sort algorithm supporting both positive and negative integers.
     * Time Complexity: O(n + k) where k is the range (max - min + 1)
     * Space Complexity: O(n + k)
     */
    static void countingSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) return;

        // Find minimum and maximum elements in array
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }

        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[n];

        // Step 1: Store count of each element (offset by min to support negative values)
        for (int i = 0; i < n; i++) {
            count[arr[i] - min]++;
        }

        // Step 2: Cumulative count to determine positions
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Build output array traversing backwards to maintain stability
        for (int i = n - 1; i >= 0; i--) {
            int val = arr[i];
            int pos = count[val - min] - 1;
            output[pos] = val;
            count[val - min]--;
        }

        // Copy back to original array
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        if (n > 0) {
            System.out.println("Enter integer elements (can include negatives):");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            countingSort(arr);
        }

        System.out.println("Sorted array using Counting Sort:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

        sc.close();
    }
}
