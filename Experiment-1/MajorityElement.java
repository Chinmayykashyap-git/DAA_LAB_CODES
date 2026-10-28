import java.util.Scanner;

public class MajorityElement {

    /**
     * Finds the majority element (appears strictly more than n/2 times) using
     * Moore's Voting Algorithm.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    static int majorityElement(int[] arr) {
        if (arr.length == 0) return -1;

        int candidate = 0;
        int count = 0;

        // Step 1: Find candidate
        for (int x : arr) {
            if (count == 0) {
                candidate = x;
            }
            if (x == candidate)
                count++;
            else
                count--;
        }

        // Step 2: Verify candidate
        count = 0;
        for (int x : arr) {
            if (x == candidate)
                count++;
        }

        if (count > arr.length / 2)
            return candidate;

        return -1;
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

        int result = majorityElement(arr);

        if (result == -1)
            System.out.println("No Majority Element");
        else
            System.out.println("Majority Element: " + result);

        sc.close();
    }
}
