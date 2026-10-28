import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BucketSort {

    /**
     * Bucket Sort algorithm for floating-point numbers.
     * Divides elements into n buckets based on normalized value in [0, 1),
     * sorts each bucket, and concatenates.
     * Average Time Complexity: O(n + k)
     * Worst Time Complexity: O(n^2)
     * Space Complexity: O(n + k)
     */
    @SuppressWarnings("unchecked")
    static void bucketSort(float[] arr) {
        int n = arr.length;
        if (n <= 1) return;

        // Find min and max
        float min = arr[0];
        float max = arr[0];
        for (float v : arr) {
            if (v < min) min = v;
            if (v > max) max = v;
        }

        // If all elements are equal, array is already sorted
        if (min == max) return;

        // Create n empty buckets
        List<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribute array elements into buckets
        for (int i = 0; i < n; i++) {
            // Normalized position in [0, 1)
            float normalized = (arr[i] - min) / (max - min);
            int bucketIdx = (int) (normalized * (n - 1));
            buckets[bucketIdx].add(arr[i]);
        }

        // Sort each bucket using Collections.sort (Insertion/TimSort)
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (float val : buckets[i]) {
                arr[index++] = val;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        float[] arr = new float[n];
        if (n > 0) {
            System.out.println("Enter floating-point elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextFloat();
            }
            bucketSort(arr);
        }

        System.out.println("Sorted array using Bucket Sort:");
        for (float x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

        sc.close();
    }
}
