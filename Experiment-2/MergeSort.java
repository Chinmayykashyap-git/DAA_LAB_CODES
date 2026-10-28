import java.util.Scanner;

public class MergeSort {

    /**
     * Merges two sorted subarrays arr[low...mid] and arr[mid+1...high].
     */
    static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
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
    }

    /**
     * Recursive Merge Sort algorithm.
     * Time Complexity: O(n log n) in all cases.
     * Space Complexity: O(n) auxiliary space.
     */
    static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
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

            mergeSort(arr, 0, n - 1);
        }

        System.out.println("Sorted array:");
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();

        sc.close();
    }
}
