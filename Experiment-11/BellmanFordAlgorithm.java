import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BellmanFordAlgorithm {

    static class Edge {
        int u;
        int v;
        int weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    private static final int INF = 1_000_000_000;

    /**
     * Bellman-Ford Single Source Shortest Path Algorithm with Negative Cycle Detection.
     * Time Complexity: O(V * E)
     * Space Complexity: O(V)
     */
    static void bellmanFord(int V, List<Edge> edges, int source) {
        int[] dist = new int[V];
        int[] parent = new int[V];

        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);

        dist[source] = 0;

        // Step 1: Relax all edges |V| - 1 times
        for (int i = 1; i < V; i++) {
            boolean updated = false;

            for (Edge edge : edges) {
                if (dist[edge.u] != INF && dist[edge.u] + edge.weight < dist[edge.v]) {
                    dist[edge.v] = dist[edge.u] + edge.weight;
                    parent[edge.v] = edge.u;
                    updated = true;
                }
            }

            // Early termination if no relaxation occurred
            if (!updated) break;
        }

        // Step 2: Check for negative-weight cycles (V-th relaxation pass)
        boolean hasNegativeCycle = false;
        for (Edge edge : edges) {
            if (dist[edge.u] != INF && dist[edge.u] + edge.weight < dist[edge.v]) {
                hasNegativeCycle = true;
                break;
            }
        }

        if (hasNegativeCycle) {
            System.out.println("\n*** NEGATIVE-WEIGHT CYCLE DETECTED! ***");
            System.out.println("The graph contains a negative-weight cycle reachable from source " + source + ".");
            System.out.println("Shortest path distances are undefined (tend to negative infinity).");
            return;
        }

        // Print shortest distances and paths
        System.out.println("\n--- Bellman-Ford Shortest Paths from Source (" + source + ") ---");
        System.out.println("Destination \tDistance \tPath");

        for (int i = 0; i < V; i++) {
            System.out.print(i + "\t\t");
            if (dist[i] >= INF / 2) {
                System.out.println("Infinity \tNo Path (Unreachable)");
            } else {
                System.out.print(dist[i] + "\t\t");
                printPath(i, parent);
                System.out.println();
            }
        }
        System.out.println("-------------------------------------------------------");
    }

    private static void printPath(int current, int[] parent) {
        List<Integer> path = new ArrayList<>();
        for (int at = current; at != -1; at = parent[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + (i < path.size() - 1 ? " -> " : ""));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Bellman-Ford Shortest Path Algorithm ===");
        System.out.print("Enter number of vertices (V): ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges (E): ");
        int E = sc.nextInt();

        List<Edge> edges = new ArrayList<>();
        System.out.println("Enter " + E + " directed edges in format (u v weight):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new Edge(u, v, w));
        }

        System.out.print("Enter source vertex: ");
        int source = sc.nextInt();

        if (source < 0 || source >= V) {
            System.out.println("Invalid source vertex.");
        } else {
            bellmanFord(V, edges, source);
        }

        sc.close();
    }
}
