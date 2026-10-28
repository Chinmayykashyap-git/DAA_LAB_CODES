import java.util.Scanner;

public class MedianOfTwoSortedArrays {

    /**
     * Finds the median of two sorted arrays using binary search partitioning.
     * Time Complexity: O(log(min(n, m)))
     * Space Complexity: O(1)
     */
    static double findMedianSortedArrays(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;

        // Ensure array a is smaller to minimize binary search range
        if (n1 > n2) {
            return findMedianSortedArrays(b, a);
        }

        int low = 0;
        int high = n1;
        int leftTotal = (n1 + n2 + 1) / 2;

        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = leftTotal - mid1;

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : a[mid1 - 1];
            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : a[mid1];

            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : b[mid2 - 1];
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : b[mid2];

            // Valid partition found
            if (l1 <= r2 && l2 <= r1) {
                // If total length is odd
                if ((n1 + n2) % 2 == 1) {
                    return Math.max(l1, l2);
                } else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            } else if (l1 > r2) {
                // Too many elements from array a in left half
                high = mid1 - 1;
            } else {
                // Too few elements from array a in left half
                low = mid1 + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted or invalid.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first sorted array: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        if (n > 0) {
            System.out.println("Enter elements of first sorted array:");
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
        }

        System.out.print("Enter size of second sorted array: ");
        int m = sc.nextInt();
        int[] b = new int[m];
        if (m > 0) {
            System.out.println("Enter elements of second sorted array:");
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }
        }

        if (n == 0 && m == 0) {
            System.out.println("Both arrays are empty, median undefined.");
        } else {
            double median = findMedianSortedArrays(a, b);
            System.out.println("Median of two sorted arrays: " + median);
        }

        sc.close();
    }
}
