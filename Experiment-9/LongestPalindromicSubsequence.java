import java.util.Scanner;

public class LongestPalindromicSubsequence {

    /**
     * Computes the length of the Longest Palindromic Subsequence (LPS) using Dynamic Programming,
     * and reconstructs the actual palindromic subsequence string.
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     */
    static void findLPS(String s) {
        int n = s.length();
        if (n == 0) {
            System.out.println("Empty string.");
            return;
        }

        int[][] dp = new int[n][n];

        // Base case: every single character is a palindrome of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill DP table for substrings of length 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (len == 2) ? 2 : 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        int lpsLength = dp[0][n - 1];
        System.out.println("Length of Longest Palindromic Subsequence: " + lpsLength);

        // Reconstruct the actual LPS string by backtracking through DP table
        char[] lpsStr = new char[lpsLength];
        int start = 0;
        int end = lpsLength - 1;

        int i = 0;
        int j = n - 1;

        while (i <= j) {
            if (i == j) {
                lpsStr[start] = s.charAt(i);
                break;
            }

            if (s.charAt(i) == s.charAt(j)) {
                lpsStr[start] = s.charAt(i);
                lpsStr[end] = s.charAt(j);
                start++;
                end--;
                i++;
                j--;
            } else if (dp[i + 1][j] >= dp[i][j - 1]) {
                i++;
            } else {
                j--;
            }
        }

        System.out.println("Longest Palindromic Subsequence: \"" + new String(lpsStr) + "\"");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine().trim();

        findLPS(s);

        sc.close();
    }
}
