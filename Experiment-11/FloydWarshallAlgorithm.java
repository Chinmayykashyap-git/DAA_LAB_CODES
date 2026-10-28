import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FloydWarshallAlgorithm {

    // Representation for unreachable distance (avoids integer overflow when adding)
    public static final int INF = 1_000_000_000;

    /**
     * Floyd-Warshall All-Pairs Shortest Path Algorithm with Path Reconstruction.
     * Time Complexity: O(V^3)
     * Space Complexity: O(V^2)
     */
    static void floydWarshall(int V, int[][] graph) {
        int[][] dist = new int[V][V];
        int[][] next = new int[V][V];

        // Initialize dist and next matrices
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != INF && i != j) {
                    next[i][j] = j;
                } else {
                    next[i][j] = -1;
                }
            }
        }

        // Floyd-Warshall core: try intermediate vertex k
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    // Prevent overflow: only relax if paths i->k and k->j exist
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        if (dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                            next[i][j] = next[i][k];
                        }
                    }
                }
            }
        }

        // Check for negative-weight cycles (diagonal dist[i][i] < 0)
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                System.out.println("\n*** NEGATIVE-WEIGHT CYCLE DETECTED! ***");
                System.out.println("Vertex " + i + " is part of a negative-weight cycle.");
                return;
            }
        }

        // Display all-pairs shortest distances
        System.out.println("\n--- All-Pairs Shortest Distance Matrix ---");
        System.out.print("From\\To\t");
        for (int j = 0; j < V; j++) System.out.print("[" + j + "]\t");
        System.out.println();

        for (int i = 0; i < V; i++) {
            System.out.print("[" + i + "]\t");
            for (int j = 0; j < V; j++) {
                if (dist[i][j] >= INF / 2) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(dist[i][j] + "\t");
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------------------");
    }

    /**
     * Reconstructs the shortest path between u and v using next matrix.
     */
    static List<Integer> constructPath(int u, int v, int[][] next) {
        if (next[u][v] == -1) return null;
        List<Integer> path = new ArrayList<>();
        path.add(u);
        while (u != v) {
            u = next[u][v];
            path.add(u);
        }
        return path;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Floyd-Warshall All-Pairs Shortest Path ===");
        System.out.print("Enter number of vertices (V): ");
        int V = sc.nextInt();

        int[][] graph = new int[V][V];
        System.out.println("Enter adjacency matrix (" + V + " x " + V + "), use -1 or 999999 to represent no edge / INF:");

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                int val = sc.nextInt();
                if (i == j) {
                    graph[i][j] = (val < 0) ? val : 0;
                } else if (val == -1 || val >= INF / 2) {
                    graph[i][j] = INF;
                } else {
                    graph[i][j] = val;
                }
            }
        }

        floydWarshall(V, graph);

        sc.close();
    }
}
