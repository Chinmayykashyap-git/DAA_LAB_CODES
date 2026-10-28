import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTreeConstruction {

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

    private Node root;

    public BinarySearchTreeConstruction() {
        this.root = null;
    }

    /**
     * Inserts a value into the BST.
     * Time Complexity: O(h) where h is tree height (O(log n) balanced, O(n) worst)
     */
    public void insert(int val) {
        root = insertRec(root, val);
    }

    private Node insertRec(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }
        if (val < node.data) {
            node.left = insertRec(node.left, val);
        } else if (val > node.data) {
            node.right = insertRec(node.right, val);
        }
        return node;
    }

    /**
     * Searches for a value in the BST.
     */
    public boolean search(int val) {
        return searchRec(root, val);
    }

    private boolean searchRec(Node node, int val) {
        if (node == null) return false;
        if (node.data == val) return true;
        if (val < node.data) return searchRec(node.left, val);
        return searchRec(node.right, val);
    }

    /**
     * Deletes a value from the BST.
     * Handles 0, 1, or 2 children (using in-order successor).
     */
    public void delete(int val) {
        root = deleteRec(root, val);
    }

    private Node deleteRec(Node node, int val) {
        if (node == null) return null;

        if (val < node.data) {
            node.left = deleteRec(node.left, val);
        } else if (val > node.data) {
            node.right = deleteRec(node.right, val);
        } else {
            // Node with only one child or no child
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Node with two children: get in-order successor (smallest in right subtree)
            node.data = minValue(node.right);
            // Delete the in-order successor
            node.right = deleteRec(node.right, node.data);
        }
        return node;
    }

    private int minValue(Node node) {
        int minv = node.data;
        while (node.left != null) {
            minv = node.left.data;
            node = node.left;
        }
        return minv;
    }

    public void inOrder() {
        System.out.print("In-order (Sorted): ");
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.data + " ");
            inOrderRec(node.right);
        }
    }

    public void preOrder() {
        System.out.print("Pre-order: ");
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }

    public void postOrder() {
        System.out.print("Post-order: ");
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.print(node.data + " ");
        }
    }

    public void levelOrder() {
        System.out.print("Level-order: ");
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTreeConstruction bst = new BinarySearchTreeConstruction();

        System.out.println("=== Binary Search Tree Construction & Operations ===");
        System.out.print("Enter number of initial elements to insert into BST: ");
        int n = sc.nextInt();
        if (n > 0) {
            System.out.println("Enter " + n + " elements:");
            for (int i = 0; i < n; i++) {
                bst.insert(sc.nextInt());
            }
        }

        bst.inOrder();
        bst.preOrder();
        bst.postOrder();
        bst.levelOrder();

        boolean running = true;
        while (running) {
            System.out.println("\nOptions: 1. Insert  2. Search  3. Delete  4. Traversals  5. Exit");
            System.out.print("Choose option (1-5): ");
            if (!sc.hasNextInt()) break;
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    bst.insert(sc.nextInt());
                    System.out.println("Inserted successfully.");
                    break;
                case 2:
                    System.out.print("Enter value to search: ");
                    int sv = sc.nextInt();
                    System.out.println(bst.search(sv) ? "Value " + sv + " found in BST." : "Value " + sv + " NOT found.");
                    break;
                case 3:
                    System.out.print("Enter value to delete: ");
                    int dv = sc.nextInt();
                    bst.delete(dv);
                    System.out.println("Deleted (if present). New in-order traversal:");
                    bst.inOrder();
                    break;
                case 4:
                    bst.inOrder();
                    bst.preOrder();
                    bst.postOrder();
                    bst.levelOrder();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        sc.close();
    }
}
