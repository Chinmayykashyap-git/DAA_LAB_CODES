import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RelativeSorting {

    /**
     * Sorts array a1 based on the relative order defined in array a2.
     * Elements of a1 not present in a2 appear at the end in ascending order.
     * Time Complexity: O(n1 log n1 + n2)
     * Space Complexity: O(n1)
     */
    static int[] relativeSortArray(int[] a1, int[] a2) {
        // Step 1: Count frequency of each element in a1
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int x : a1) {
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        }

        int[] result = new int[a1.length];
        int index = 0;

        // Step 2: Place elements of a1 in the order they appear in a2
        for (int x : a2) {
            if (freqMap.containsKey(x)) {
                int count = freqMap.get(x);
                for (int i = 0; i < count; i++) {
                    result[index++] = x;
                }
                freqMap.remove(x);
            }
        }

        // Step 3: Collect all remaining elements of a1 not present in a2
        List<Integer> remaining = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int val = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                remaining.add(val);
            }
        }

        // Step 4: Sort remaining elements in ascending order and append
        Collections.sort(remaining);
        for (int x : remaining) {
            result[index++] = x;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first array (A1): ");
        int n1 = sc.nextInt();
        int[] a1 = new int[n1];
        System.out.println("Enter elements of A1:");
        for (int i = 0; i < n1; i++) {
            a1[i] = sc.nextInt();
        }

        System.out.print("Enter size of second array (A2): ");
        int n2 = sc.nextInt();
        int[] a2 = new int[n2];
        System.out.println("Enter elements of A2 (order array):");
        for (int i = 0; i < n2; i++) {
            a2[i] = sc.nextInt();
        }

        int[] sorted = relativeSortArray(a1, a2);

        System.out.println("Array after Relative Sorting:");
        for (int x : sorted) {
            System.out.print(x + " ");
        }
        System.out.println();

        sc.close();
    }
}
