import java.util.Scanner;

public class StrassensMatrixMultiplication {

    /**
     * Adds two square matrices: C = A + B
     */
    static int[][] add(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }

    /**
     * Subtracts two square matrices: C = A - B
     */
    static int[][] subtract(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }

    /**
     * Recursive Strassen's matrix multiplication for n x n matrices where n is a power of 2.
     * Time Complexity: O(n^log2(7)) ≈ O(n^2.807)
     */
    static int[][] strassenR(int[][] a, int[][] b) {
        int n = a.length;

        // Base case: 1x1 matrix or threshold for standard multiplication
        if (n <= 2) {
            int[][] c = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        c[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
            return c;
        }

        int half = n / 2;

        // Divide matrices A and B into 4 submatrices of size (half x half)
        int[][] a11 = new int[half][half];
        int[][] a12 = new int[half][half];
        int[][] a21 = new int[half][half];
        int[][] a22 = new int[half][half];

        int[][] b11 = new int[half][half];
        int[][] b12 = new int[half][half];
        int[][] b21 = new int[half][half];
        int[][] b22 = new int[half][half];

        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                a11[i][j] = a[i][j];
                a12[i][j] = a[i][j + half];
                a21[i][j] = a[i + half][j];
                a22[i][j] = a[i + half][j + half];

                b11[i][j] = b[i][j];
                b12[i][j] = b[i][j + half];
                b21[i][j] = b[i + half][j];
                b22[i][j] = b[i + half][j + half];
            }
        }

        // Calculate 7 Strassen products recursively:
        // P1 = A11 * (B12 - B22)
        int[][] p1 = strassenR(a11, subtract(b12, b22));
        // P2 = (A11 + A12) * B22
        int[][] p2 = strassenR(add(a11, a12), b22);
        // P3 = (A21 + A22) * B11
        int[][] p3 = strassenR(add(a21, a22), b11);
        // P4 = A22 * (B21 - B11)
        int[][] p4 = strassenR(a22, subtract(b21, b11));
        // P5 = (A11 + A22) * (B11 + B22)
        int[][] p5 = strassenR(add(a11, a22), add(b11, b22));
        // P6 = (A12 - A22) * (B21 + B22)
        int[][] p6 = strassenR(subtract(a12, a22), add(b21, b22));
        // P7 = (A11 - A21) * (B11 + B12)
        int[][] p7 = strassenR(subtract(a11, a21), add(b11, b12));

        // Combine submatrices into result submatrices:
        // C11 = P5 + P4 - P2 + P6
        int[][] c11 = add(subtract(add(p5, p4), p2), p6);
        // C12 = P1 + P2
        int[][] c12 = add(p1, p2);
        // C21 = P3 + P4
        int[][] c21 = add(p3, p4);
        // C22 = P1 + P5 - P3 - P7
        int[][] c22 = subtract(subtract(add(p1, p5), p3), p7);

        // Assemble full matrix C
        int[][] c = new int[n][n];
        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                c[i][j] = c11[i][j];
                c[i][j + half] = c12[i][j];
                c[i + half][j] = c21[i][j];
                c[i + half][j + half] = c22[i][j];
            }
        }

        return c;
    }

    /**
     * Strassen's Multiplication wrapper that handles any matrix dimensions,
     * including non-power-of-two sizes, by padding with zeros to the next power of 2.
     */
    static int[][] multiply(int[][] a, int[][] b, int r1, int c1, int r2, int c2) {
        if (c1 != r2) {
            System.out.println("Multiplication not possible: Columns of A (" + c1 + ") must equal Rows of B (" + r2 + ")");
            return null;
        }

        // Find the maximum dimension and pad to the next power of 2
        int maxDim = Math.max(Math.max(r1, c1), Math.max(r2, c2));
        int m = 1;
        while (m < maxDim) {
            m *= 2;
        }

        int[][] aPadded = new int[m][m];
        int[][] bPadded = new int[m][m];

        for (int i = 0; i < r1; i++) {
            System.arraycopy(a[i], 0, aPadded[i], 0, c1);
        }
        for (int i = 0; i < r2; i++) {
            System.arraycopy(b[i], 0, bPadded[i], 0, c2);
        }

        // Multiply padded matrices
        int[][] cPadded = strassenR(aPadded, bPadded);

        // Extract the original r1 x c2 result matrix
        int[][] result = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            System.arraycopy(cPadded[i], 0, result[i], 0, c2);
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

        int[][] product = multiply(a, b, r1, c1, r2, c2);

        if (product != null) {
            System.out.println("Product Matrix using Strassen's Algorithm (" + r1 + " x " + c2 + "):");
            printMatrix(product);
        }

        sc.close();
    }
}
