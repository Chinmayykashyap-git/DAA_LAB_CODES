import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LargestBSTInBinaryTree {

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
     * Information structure returned by each subtree during bottom-up traversal.
     */
    static class SubtreeInfo {
        boolean isBST;
        int size;
        int min;
        int max;

        SubtreeInfo(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    /**
     * Bottom-up post-order traversal to find the size of the largest BST in a Binary Tree.
     * Time Complexity: O(n) - visits each node exactly once
     * Space Complexity: O(h) recursion stack
     */
    static SubtreeInfo largestBSTHelper(Node root) {
        // Base case: empty tree is a valid BST of size 0
        if (root == null) {
            return new SubtreeInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // Post-order traversal: process left and right subtrees first
        SubtreeInfo leftInfo = largestBSTHelper(root.left);
        SubtreeInfo rightInfo = largestBSTHelper(root.right);

        // Check if current tree rooted at root forms a valid BST
        if (leftInfo.isBST && rightInfo.isBST && root.data > leftInfo.max && root.data < rightInfo.min) {
            int currentSize = 1 + leftInfo.size + rightInfo.size;
            int currentMin = Math.min(root.data, leftInfo.min);
            int currentMax = Math.max(root.data, rightInfo.max);

            return new SubtreeInfo(true, currentSize, currentMin, currentMax);
        }

        // If not a valid BST at current root, return largest BST size found in children
        return new SubtreeInfo(false, Math.max(leftInfo.size, rightInfo.size), 0, 0);
    }

    public static int largestBST(Node root) {
        return largestBSTHelper(root).size;
    }

    /**
     * Builds a binary tree from level-order input array where -1 indicates null.
     */
    static Node buildTreeFromLevelOrder(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;

        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            Node curr = q.poll();

            // Left child
            if (i < arr.length && arr[i] != -1) {
                curr.left = new Node(arr[i]);
                q.offer(curr.left);
            }
            i++;

            // Right child
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

        System.out.println("=== Largest BST in a Binary Tree ===");
        System.out.println("Enter number of elements in level-order representation (-1 for null nodes):");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements (e.g., 50 30 60 5 20 45 70 -1 -1 -1 -1 -1 -1 65 80):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTreeFromLevelOrder(arr);
        int maxBstSize = largestBST(root);

        System.out.println("Size (number of nodes) of the Largest BST in this Binary Tree: " + maxBstSize);

        sc.close();
    }
}
