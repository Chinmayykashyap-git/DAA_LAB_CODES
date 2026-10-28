import java.util.Scanner;

public class SmallestMissingPositiveInteger {

    /**
     * Swaps elements at index i and j in array arr.
     */
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Finds the smallest missing positive integer in an unsorted array.
     * Uses Cyclic Sort (in-place bucket placement) to place each number x in [1, n] at index x - 1.
     * Time Complexity: O(n) - each element is moved at most once to its target index
     * Space Complexity: O(1) auxiliary space
     */
    static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;

        // Step 1: Place each positive integer x in the range [1, n] at index x - 1
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                swap(arr, i, arr[i] - 1);
            }
        }

        // Step 2: The first index i where arr[i] != i + 1 corresponds to missing number (i + 1)
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: If all numbers 1...n are present, smallest missing is n + 1
        return n + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        if (n > 0) {
            System.out.println("Enter array elements (can include negatives, zeros, and duplicates):");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
        }

        int result = findFirstMissingPositive(arr);
        System.out.println("Smallest Missing Positive Integer: " + result);

        sc.close();
    }
}
