import java.util.Arrays;
import java.util.Scanner;

public class CityWithFewestNeighbors {

    private static final int INF = 1_000_000_000;

    /**
     * Finds the city that has the smallest number of reachable cities within distanceThreshold.
     * Tie-breaking rule: If there are multiple cities with the same minimum count,
     * returns the city with the GREATEST numerical index.
     *
     * Uses Floyd-Warshall to compute all-pairs shortest paths.
     * Time Complexity: O(n^3)
     * Space Complexity: O(n^2)
     */
    static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];

        // Step 1: Initialize distance matrix
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // Fill direct edge weights (bidirectional/undirected)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        // Step 2: Floyd-Warshall all-pairs shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        if (dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }

        // Step 3: Count reachable neighbors within distanceThreshold for each city
        int minReachableCount = Integer.MAX_VALUE;
        int bestCity = -1;

        System.out.println("\n--- Reachable Cities Within Threshold (" + distanceThreshold + ") ---");
        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            System.out.print("City " + i + " can reach: ");
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    reachableCount++;
                    System.out.print(j + " (dist " + dist[i][j] + ") ");
                }
            }
            System.out.println("-> Total: " + reachableCount);

            // Tie-breaking: By using "<=", when reachableCount == minReachableCount,
            // the greater city index i naturally overwrites previous indices!
            if (reachableCount <= minReachableCount) {
                minReachableCount = reachableCount;
                bestCity = i;
            }
        }

        return bestCity;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Find the City With the Smallest Number of Neighbors at a Threshold Distance ===");
        System.out.print("Enter number of cities (n): ");
        int n = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int m = sc.nextInt();

        int[][] edges = new int[m][3];
        System.out.println("Enter " + m + " edges in format (from to weight):");
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        System.out.print("Enter distance threshold: ");
        int distanceThreshold = sc.nextInt();

        int resultCity = findTheCity(n, edges, distanceThreshold);

        System.out.println("\nCity with the fewest reachable neighbors (tie-breaking with greatest index): City " + resultCity);

        sc.close();
    }
}
