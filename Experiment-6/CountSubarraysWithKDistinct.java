import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountSubarraysWithKDistinct {

    /**
     * Helper method to count subarrays with AT MOST k distinct elements.
     * Uses sliding window with two pointers.
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     */
    static long atMostKDistinct(int[] arr, int k) {
        if (k <= 0) return 0;

        int left = 0;
        long count = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < arr.length; right++) {
            freqMap.put(arr[right], freqMap.getOrDefault(arr[right], 0) + 1);

            // Shrink window if number of distinct elements exceeds k
            while (freqMap.size() > k) {
                int leftVal = arr[left];
                int leftCount = freqMap.get(leftVal);
                if (leftCount == 1) {
                    freqMap.remove(leftVal);
                } else {
                    freqMap.put(leftVal, leftCount - 1);
                }
                left++;
            }

            // All subarrays ending at right and starting from [left...right] have <= k distinct elements
            count += (right - left + 1);
        }

        return count;
    }

    /**
     * Counts subarrays with EXACTLY k distinct elements.
     * exactly(k) = atMost(k) - atMost(k - 1)
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     */
    static long countSubarraysWithExactlyKDistinct(int[] arr, int k) {
        if (k <= 0 || arr.length < k) return 0;
        return atMostKDistinct(arr, k) - atMostKDistinct(arr, k - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter K (number of distinct elements): ");
        int k = sc.nextInt();

        long result = countSubarraysWithExactlyKDistinct(arr, k);
        System.out.println("Number of subarrays with exactly " + k + " distinct elements: " + result);

        sc.close();
    }
}
