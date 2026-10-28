import java.util.Scanner;

public class MaximumProductSubarray {

    /**
     * Finds the contiguous subarray within an array which has the largest product.
     * Uses Kadane's variation tracking both max and min products to handle negative numbers.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    static long maxProduct(int[] arr) {
        if (arr.length == 0) return 0;

        long maxSoFar = arr[0];
        long minSoFar = arr[0];
        long maxProductResult = arr[0];

        for (int i = 1; i < arr.length; i++) {
            long current = arr[i];

            // Multiplying by a negative number swaps the maximum and minimum
            if (current < 0) {
                long temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            maxSoFar = Math.max(current, maxSoFar * current);
            minSoFar = Math.min(current, minSoFar * current);

            maxProductResult = Math.max(maxProductResult, maxSoFar);
        }

        return maxProductResult;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        if (n > 0) {
            System.out.println("Enter array elements (can include positive, negative, and zeros):");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
        }

        if (n == 0) {
            System.out.println("Array is empty.");
        } else {
            long result = maxProduct(arr);
            System.out.println("Maximum Product of a Subarray: " + result);
        }

        sc.close();
    }
}
