import java.util.Scanner;

public class LowestCommonAncestor {

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
     * Inserts value into BST.
     */
    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.data) root.left = insert(root.left, val);
        else if (val > root.data) root.right = insert(root.right, val);
        return root;
    }

    /**
     * Finds Lowest Common Ancestor in a Binary Search Tree (BST).
     * Time Complexity: O(h) where h is height of tree
     * Space Complexity: O(h) recursion stack
     */
    static Node findLcaBST(Node root, int n1, int n2) {
        if (root == null) return null;

        // If both n1 and n2 are smaller than root, LCA is in left subtree
        if (n1 < root.data && n2 < root.data) {
            return findLcaBST(root.left, n1, n2);
        }

        // If both n1 and n2 are greater than root, LCA is in right subtree
        if (n1 > root.data && n2 > root.data) {
            return findLcaBST(root.right, n1, n2);
        }

        // Otherwise, this root is the split point and hence the LCA
        return root;
    }

    /**
     * Helper to verify if a node value exists in the tree.
     */
    static boolean find(Node root, int val) {
        if (root == null) return false;
        if (root.data == val) return true;
        return find(root.left, val) || find(root.right, val);
    }

    static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Lowest Common Ancestor (LCA) in BST ===");
        System.out.print("Enter number of nodes in BST: ");
        int n = sc.nextInt();

        Node root = null;
        if (n > 0) {
            System.out.println("Enter " + n + " elements to construct BST:");
            for (int i = 0; i < n; i++) {
                root = insert(root, sc.nextInt());
            }
        }

        System.out.print("BST In-order Traversal: ");
        inOrder(root);
        System.out.println();

        System.out.print("Enter first node value (n1): ");
        int n1 = sc.nextInt();
        System.out.print("Enter second node value (n2): ");
        int n2 = sc.nextInt();

        if (!find(root, n1) || !find(root, n2)) {
            System.out.println("Error: One or both values do not exist in the BST.");
        } else {
            Node lca = findLcaBST(root, n1, n2);
            if (lca != null) {
                System.out.println("Lowest Common Ancestor of " + n1 + " and " + n2 + " is: " + lca.data);
            } else {
                System.out.println("No LCA found.");
            }
        }

        sc.close();
    }
}
