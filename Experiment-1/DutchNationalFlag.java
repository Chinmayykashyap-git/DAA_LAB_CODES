import java.util.Scanner;

public class DutchNationalFlag {

    /**
     * Sorts an array consisting only of 0s, 1s, and 2s in a single pass (Dutch National Flag Algorithm).
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    static void sort012(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
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
            System.out.println("Enter only 0, 1 and 2:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
        }

        sort012(arr);

        System.out.println("Sorted array:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

        sc.close();
    }
}
