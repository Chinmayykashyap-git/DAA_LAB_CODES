import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaximumBottleneckPath {

    static class Edge {
        int to;
        int capacity;

        Edge(int to, int capacity) {
            this.to = to;
            this.capacity = capacity;
        }
    }

    static class NodeCap implements Comparable<NodeCap> {
        int node;
        int cap;

        NodeCap(int node, int cap) {
            this.node = node;
            this.cap = cap;
        }

        // Max-Heap: higher bottleneck capacity has higher priority
        @Override
        public int compareTo(NodeCap other) {
            return Integer.compare(other.cap, this.cap);
        }
    }

    /**
     * Finds the path from source to target that maximizes the minimum edge capacity (bottleneck).
     * Modified Dijkstra using a Max-Heap.
     * Time Complexity: O((V + E) log V)
     * Space Complexity: O(V + E)
     */
    static void findMaxBottleneckPath(int V, List<List<Edge>> adj, int source, int target) {
        int[] maxCap = new int[V];
        int[] parent = new int[V];
        Arrays.fill(maxCap, -1);
        Arrays.fill(parent, -1);

        PriorityQueue<NodeCap> pq = new PriorityQueue<>();

        maxCap[source] = Integer.MAX_VALUE;
        pq.offer(new NodeCap(source, Integer.MAX_VALUE));

        while (!pq.isEmpty()) {
            NodeCap curr = pq.poll();
            int u = curr.node;
            int cap = curr.cap;

            if (u == target) {
                break; // Target reached with maximum possible bottleneck
            }

            if (cap < maxCap[u]) continue;

            for (Edge edge : adj.get(u)) {
                int v = edge.to;
                int weight = edge.capacity;

                // The bottleneck capacity of the path through u to v
                int pathCap = Math.min(maxCap[u], weight);

                if (pathCap > maxCap[v]) {
                    maxCap[v] = pathCap;
                    parent[v] = u;
                    pq.offer(new NodeCap(v, pathCap));
                }
            }
        }

        if (maxCap[target] == -1) {
            System.out.println("No path exists between vertex " + source + " and vertex " + target + ".");
        } else {
            System.out.println("\nMaximum Bottleneck Capacity from " + source + " to " + target + ": " + maxCap[target]);
            System.out.print("Bottleneck Path: ");

            List<Integer> path = new ArrayList<>();
            for (int at = target; at != -1; at = parent[at]) {
                path.add(at);
            }
            Collections.reverse(path);

            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i) + (i < path.size() - 1 ? " -> " : ""));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Maximum Bottleneck Path (Widest Path) ===");
        System.out.print("Enter number of vertices (V): ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges (E): ");
        int E = sc.nextInt();

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter " + E + " edges in format (u v capacity) [0-indexed]:");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int cap = sc.nextInt();

            // Undirected graph
            adj.get(u).add(new Edge(v, cap));
            adj.get(v).add(new Edge(u, cap));
        }

        System.out.print("Enter source vertex: ");
        int source = sc.nextInt();

        System.out.print("Enter destination vertex: ");
        int target = sc.nextInt();

        findMaxBottleneckPath(V, adj, source, target);

        sc.close();
    }
}
