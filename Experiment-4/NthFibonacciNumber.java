import java.util.Scanner;

public class NthFibonacciNumber {

    /**
     * Multiplies two 2x2 matrices: C = A * B
     */
    static void multiply(long[][] a, long[][] b) {
        long x = a[0][0] * b[0][0] + a[0][1] * b[1][0];
        long y = a[0][0] * b[0][1] + a[0][1] * b[1][1];
        long z = a[1][0] * b[0][0] + a[1][1] * b[1][0];
        long w = a[1][0] * b[0][1] + a[1][1] * b[1][1];

        a[0][0] = x;
        a[0][1] = y;
        a[1][0] = z;
        a[1][1] = w;
    }

    /**
     * Raises 2x2 matrix M to the power n using repeated squaring.
     * Time Complexity: O(log n)
     */
    static void power(long[][] m, int n) {
        if (n == 0 || n == 1) return;

        long[][] base = {{1, 1}, {1, 0}};

        power(m, n / 2);
        multiply(m, m);

        if (n % 2 != 0) {
            multiply(m, base);
        }
    }

    /**
     * Computes the N-th Fibonacci number using Matrix Exponentiation.
     * Time Complexity: O(log n)
     * Space Complexity: O(log n) recursion call stack
     */
    static long fibonacciMatrixExponentiation(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        long[][] m = {{1, 1}, {1, 0}};
        power(m, n - 1);

        return m[0][0];
    }

    /**
     * Dynamic Programming approach (iterative, O(1) space).
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    static long fibonacciDP(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        long prev2 = 0;
        long prev1 = 1;
        long curr = 0;

        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N (non-negative integer): ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Fibonacci is defined for non-negative integers.");
        } else {
            long resultMatrix = fibonacciMatrixExponentiation(n);
            long resultDP = fibonacciDP(n);

            System.out.println("--- Results ---");
            System.out.println("Matrix Exponentiation O(log n): F(" + n + ") = " + resultMatrix);
            System.out.println("Dynamic Programming O(n):       F(" + n + ") = " + resultDP);
        }

        sc.close();
    }
}
