import java.util.Scanner;

public class MatrixMultiplication {

    /**
     * Multiplies two matrices A (r1 x c1) and B (r2 x c2).
     * Time Complexity: O(r1 * c1 * c2)
     * Space Complexity: O(r1 * c2) for the product matrix
     */
    static int[][] multiplyMatrices(int[][] a, int[][] b, int r1, int c1, int r2, int c2) {
        if (c1 != r2) {
            System.out.println("Matrix multiplication not possible: columns of A (" + c1 + ") must equal rows of B (" + r2 + ").");
            return null;
        }

        int[][] result = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < c1; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns of Matrix A: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        int[][] a = new int[r1][c1];
        System.out.println("Enter elements of Matrix A:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter rows and columns of Matrix B: ");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        int[][] b = new int[r2][c2];
        System.out.println("Enter elements of Matrix B:");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        int[][] product = multiplyMatrices(a, b, r1, c1, r2, c2);

        if (product != null) {
            System.out.println("Product Matrix C (" + r1 + " x " + c2 + "):");
            printMatrix(product);
        }

        sc.close();
    }
}
