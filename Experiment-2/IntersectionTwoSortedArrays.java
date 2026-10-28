import java.util.Scanner;

public class IntersectionTwoSortedArrays {

    /**
     * Computes the intersection of two sorted arrays.
     * Time Complexity: O(n + m)
     * Space Complexity: O(1) auxiliary
     */
    static void intersection(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        boolean foundAny = false;

        System.out.println("Intersection:");

        while (i < a.length && j < b.length) {
            // Skip duplicates in array a
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }

            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                System.out.print(a[i] + " ");
                foundAny = true;
                i++;
                j++;
            }
        }
        if (!foundAny) {
            System.out.print("No common elements");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        if (n > 0) {
            System.out.println("Enter sorted elements for first array:");
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
        }

        System.out.print("Enter size of second array: ");
        int m = sc.nextInt();
        int[] b = new int[m];
        if (m > 0) {
            System.out.println("Enter sorted elements for second array:");
            for (int i = 0; i < m; i++)
                b[i] = sc.nextInt();
        }

        intersection(a, b);

        sc.close();
    }
}
