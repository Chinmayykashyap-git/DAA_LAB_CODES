import java.util.Scanner;

public class MinimumWindowSubstring {

    /**
     * Finds the minimum length contiguous substring of s that contains all characters
     * of t (including duplicate occurrences).
     * Two-pointer sliding window approach.
     * Time Complexity: O(|s| + |t|)
     * Space Complexity: O(1) using fixed-size ASCII frequency arrays
     */
    static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] targetCount = new int[128];
        for (char c : t.toCharArray()) {
            targetCount[c]++;
        }

        // Count number of distinct characters in t that need to be matched
        int requiredDistinct = 0;
        for (int count : targetCount) {
            if (count > 0) requiredDistinct++;
        }

        int[] windowCount = new int[128];
        int formedDistinct = 0;

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            windowCount[rightChar]++;

            // If current char frequency matches target frequency, increment formed
            if (targetCount[rightChar] > 0 && windowCount[rightChar] == targetCount[rightChar]) {
                formedDistinct++;
            }

            // Try to shrink window from left as long as all characters are satisfied
            while (left <= right && formedDistinct == requiredDistinct) {
                // Update shortest valid window
                if ((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    startIdx = left;
                }

                char leftChar = s.charAt(left);
                windowCount[leftChar]--;

                if (targetCount[leftChar] > 0 && windowCount[leftChar] < targetCount[leftChar]) {
                    formedDistinct--;
                }

                left++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(startIdx, startIdx + minLen);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string S: ");
        String s = sc.nextLine().trim();

        System.out.print("Enter string T: ");
        String t = sc.nextLine().trim();

        String result = minWindow(s, t);

        if (result.isEmpty()) {
            System.out.println("No window substring of S contains all characters of T.");
        } else {
            System.out.println("Minimum Window Substring: \"" + result + "\" (Length: " + result.length() + ")");
        }

        sc.close();
    }
}
