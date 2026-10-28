import java.util.Scanner;

public class InsertionSortIterative {

    /**
     * Sorts an array of integers in non-decreasing order using Iterative Insertion Sort.
     * Time Complexity: O(n^2) worst/average, O(n) best case (already sorted).
     * Space Complexity: O(1) auxiliary space.
     */
    static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift elements greater than key to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
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

        insertionSort(arr);

        System.out.println("Sorted array:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

        sc.close();
    }
}
