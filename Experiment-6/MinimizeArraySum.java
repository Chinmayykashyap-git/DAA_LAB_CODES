import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimizeArraySum {

    /**
     * Minimizes array sum after K operations.
     * In each operation, the maximum element x is chosen and replaced by floor(x / 2) [or ceil(x / 2)].
     * Standard problem: pick max element x, replace with floor(x / 2) (or ceil(x / 2) if halving to minimize).
     * Here we reduce the largest element: x -> (x + 1) / 2 or floor(x / 2).
     * In classic DAA / LeetCode 1046 problem: replace x with ceil(x / 2) or floor(x / 2).
     * Replacing with floor(x / 2) gives the maximum possible reduction: x - floor(x / 2) = ceil(x / 2).
     * Time Complexity: O(n + k log n)
     * Space Complexity: O(n)
     */
    static long minimizeSum(int[] arr, int k) {
        if (arr.length == 0) return 0;

        // Max-Heap to always retrieve and reduce the largest element
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int x : arr) {
            maxHeap.offer(x);
        }

        // Perform k operations
        while (k > 0 && !maxHeap.isEmpty()) {
            int top = maxHeap.poll();
            if (top == 0) {
                maxHeap.offer(0);
                break; // Further reductions won't decrease the sum
            }

            int reduced = top / 2; // Floor reduction: replacing with half
            maxHeap.offer(reduced);
            k--;
        }

        // Calculate total remaining sum
        long totalSum = 0;
        for (int val : maxHeap) {
            totalSum += val;
        }

        return totalSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter positive array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter K (number of operations): ");
        int k = sc.nextInt();

        long minSum = minimizeSum(arr, k);
        System.out.println("Minimum Array Sum After " + k + " Operations: " + minSum);

        sc.close();
    }
}
