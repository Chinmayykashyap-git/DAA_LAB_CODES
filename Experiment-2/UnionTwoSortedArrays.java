import java.util.Scanner;

public class UnionTwoSortedArrays {

    /**
     * Computes the union of two sorted arrays.
     * Time Complexity: O(n + m)
     * Space Complexity: O(1) auxiliary
     */
    static void union(int[] a, int[] b) {
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            // Avoid printing duplicate values from array a
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            // Avoid printing duplicate values from array b
            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }

            if (a[i] < b[j]) {
                System.out.print(a[i] + " ");
                i++;
            } else if (a[i] > b[j]) {
                System.out.print(b[j] + " ");
                j++;
            } else {
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
        }

        while (i < a.length) {
            if (i == 0 || a[i] != a[i - 1]) {
                System.out.print(a[i] + " ");
            }
            i++;
        }

        while (j < b.length) {
            if (j == 0 || b[j] != b[j - 1]) {
                System.out.print(b[j] + " ");
            }
            j++;
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

        System.out.println("Union:");
        union(a, b);

        sc.close();
    }
}
