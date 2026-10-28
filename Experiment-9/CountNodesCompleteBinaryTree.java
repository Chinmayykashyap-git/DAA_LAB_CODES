import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CountNodesCompleteBinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Computes the height along the leftmost path.
     */
    static int getLeftHeight(Node node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    /**
     * Computes the height along the rightmost path.
     */
    static int getRightHeight(Node node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }

    /**
     * Counts nodes in a Complete Binary Tree in O(log^2 n) time.
     * If left height equals right height, the subtree is a Full Binary Tree with (2^h - 1) nodes.
     * Otherwise, recursively computes 1 + count(left) + count(right).
     */
    static int countNodes(Node root) {
        if (root == null) return 0;

        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);

        // If left and right heights are equal, it's a full binary tree
        if (lh == rh) {
            return (1 << lh) - 1; // 2^lh - 1
        }

        // Otherwise recurse on left and right subtrees
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * Builds a tree from level-order input array where -1 indicates null.
     */
    static Node buildTreeFromLevelOrder(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;

        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            Node curr = q.poll();

            if (i < arr.length && arr[i] != -1) {
                curr.left = new Node(arr[i]);
                q.offer(curr.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                curr.right = new Node(arr[i]);
                q.offer(curr.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Count Nodes in a Complete Binary Tree ===");
        System.out.print("Enter number of elements in level order representation (-1 for null): ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements (e.g. 1 2 3 4 5 6):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTreeFromLevelOrder(arr);
        int totalNodes = countNodes(root);

        System.out.println("Total number of nodes in the Complete Binary Tree: " + totalNodes);

        sc.close();
    }
}
