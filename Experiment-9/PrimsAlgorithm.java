import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimsAlgorithm {

    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Pair implements Comparable<Pair> {
        int vertex;
        int weight;

        Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    /**
     * Prim's Algorithm to find the Minimum Spanning Tree (MST) of an undirected weighted graph.
     * Time Complexity: O((V + E) log V) using an Adjacency List and PriorityQueue
     * Space Complexity: O(V + E)
     */
    static void primsMST(int V, List<List<Edge>> adj) {
        boolean[] inMST = new boolean[V];
        int[] key = new int[V];
        int[] parent = new int[V];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Start from vertex 0
        key[0] = 0;
        pq.offer(new Pair(0, 0));

        long totalWeight = 0;
        int edgesCount = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.vertex;

            if (inMST[u]) continue;

            inMST[u] = true;
            totalWeight += curr.weight;
            if (parent[u] != -1) {
                edgesCount++;
            }

            // Traverse adjacent edges
            for (Edge edge : adj.get(u)) {
                int v = edge.to;
                int w = edge.weight;

                if (!inMST[v] && w < key[v]) {
                    key[v] = w;
                    parent[v] = u;
                    pq.offer(new Pair(v, w));
                }
            }
        }

        // Check if graph was disconnected
        if (edgesCount < V - 1 && V > 1) {
            System.out.println("\nWarning: The graph is disconnected. Minimum Spanning Tree does not cover all vertices.");
        }

        System.out.println("\n--- Minimum Spanning Tree Edges ---");
        System.out.println("Edge \t\tWeight");
        for (int i = 1; i < V; i++) {
            if (parent[i] != -1) {
                System.out.println(parent[i] + " - " + i + "\t\t" + key[i]);
            }
        }
        System.out.println("-----------------------------------");
        System.out.println("Total Minimum Spanning Tree Weight: " + totalWeight);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Prim's Minimum Spanning Tree Algorithm ===");
        System.out.print("Enter number of vertices (V): ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges (E): ");
        int E = sc.nextInt();

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter " + E + " edges in format (u v weight), 0-indexed [0 to " + (V - 1) + "]:");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            // Undirected graph
            adj.get(u).add(new Edge(v, w));
            adj.get(v).add(new Edge(u, w));
        }

        if (V > 0) {
            primsMST(V, adj);
        } else {
            System.out.println("Graph has 0 vertices.");
        }

        sc.close();
    }
}
