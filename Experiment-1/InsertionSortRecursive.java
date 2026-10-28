import java.util.Scanner;

public class InsertionSortRecursive {

    /**
     * Recursively sorts an array using Insertion Sort.
     * Time Complexity: O(n^2) worst/average, O(n) best case.
     * Space Complexity: O(n) call stack overhead.
     */
    static void insertionSort(int[] arr, int n) {
        // Base case: array of size 0 or 1 is already sorted
        if (n <= 1)
            return;

        // Sort first n-1 elements
        insertionSort(arr, n - 1);

        // Insert last element into sorted portion [0...n-2]
        int last = arr[n - 1];
        int j = n - 2;

        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = last;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input!");
            sc.close();
            return;
        }
        int n = sc.nextInt();
        if (n < 0) {
            System.out.println("Array size cannot be negative!");
            sc.close();
            return;
        }

        int[] arr = new int[n];
        if (n > 0) {
            System.out.println("Enter elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
        }

        insertionSort(arr, n);

        System.out.println("Sorted array:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

        sc.close();
    }
}
