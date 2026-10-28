import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstrasAlgorithm {

    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class NodeDist implements Comparable<NodeDist> {
        int node;
        int dist;

        NodeDist(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(NodeDist other) {
            return Integer.compare(this.dist, other.dist);
        }
    }

    /**
     * Dijkstra's Single Source Shortest Path Algorithm using Min-Heap.
     * Assumption: Edge weights must be non-negative.
     * Time Complexity: O((V + E) log V)
     * Space Complexity: O(V + E)
     */
    static void dijkstra(int V, List<List<Edge>> adj, int source) {
        int[] dist = new int[V];
        int[] parent = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        PriorityQueue<NodeDist> pq = new PriorityQueue<>();

        dist[source] = 0;
        pq.offer(new NodeDist(source, 0));

        while (!pq.isEmpty()) {
            NodeDist curr = pq.poll();
            int u = curr.node;
            int d = curr.dist;

            // If already found a shorter path to u, skip
            if (d > dist[u]) continue;

            for (Edge edge : adj.get(u)) {
                int v = edge.to;
                int weight = edge.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    parent[v] = u;
                    pq.offer(new NodeDist(v, dist[v]));
                }
            }
        }

        System.out.println("\n--- Shortest Paths from Source (" + source + ") ---");
        System.out.println("Destination \tDistance \tPath");

        for (int i = 0; i < V; i++) {
            System.out.print(i + "\t\t");
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("Infinity \tNo Path (Unreachable)");
            } else {
                System.out.print(dist[i] + "\t\t");
                printPath(i, parent);
                System.out.println();
            }
        }
        System.out.println("----------------------------------------------");
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

        System.out.println("=== Dijkstra's Shortest Path Algorithm ===");
        System.out.print("Enter number of vertices (V): ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges (E): ");
        int E = sc.nextInt();

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter " + E + " edges in format (u v weight):");
        boolean hasNegativeWeight = false;

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            // Validate non-negative weight assumption
            if (w < 0) {
                hasNegativeWeight = true;
            }

            adj.get(u).add(new Edge(v, w));
        }

        if (hasNegativeWeight) {
            System.out.println("\nError: Dijkstra's algorithm requires all edge weights to be non-negative!");
            System.out.println("Use the Bellman-Ford algorithm for graphs with negative edge weights.");
            sc.close();
            return;
        }

        System.out.print("Enter source vertex [0 to " + (V - 1) + "]: ");
        int source = sc.nextInt();

        if (source < 0 || source >= V) {
            System.out.println("Invalid source vertex.");
        } else {
            dijkstra(V, adj, source);
        }

        sc.close();
    }
}
