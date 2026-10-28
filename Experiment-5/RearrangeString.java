import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RearrangeString {

    static class CharFreq {
        char ch;
        int freq;

        CharFreq(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    /**
     * Rearranges characters of string s such that no two adjacent characters are identical.
     * Uses a Max-Heap based on character frequencies.
     * Time Complexity: O(n log k) where k <= 256 is the alphabet size
     * Space Complexity: O(k)
     *
     * Returns the rearranged string, or empty string "" if rearrangement is impossible.
     */
    static String rearrangeString(String s) {
        if (s == null || s.length() <= 1) return s;

        int n = s.length();
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // If any character frequency exceeds ceil(n / 2), valid arrangement is impossible
        int maxAllowed = (n + 1) / 2;
        for (int count : freqMap.values()) {
            if (count > maxAllowed) {
                return ""; // Impossible
            }
        }

        // Max-Heap ordered by frequency descending
        PriorityQueue<CharFreq> maxHeap = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            maxHeap.offer(new CharFreq(entry.getKey(), entry.getValue()));
        }

        StringBuilder result = new StringBuilder();
        CharFreq prev = null;

        while (!maxHeap.isEmpty()) {
            CharFreq current = maxHeap.poll();
            result.append(current.ch);
            current.freq--;

            // If previously placed character still has remaining frequency, re-add it to heap
            if (prev != null && prev.freq > 0) {
                maxHeap.offer(prev);
            }

            prev = current;
        }

        return (result.length() == n) ? result.toString() : "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string to rearrange: ");
        String s = sc.nextLine().trim();

        String rearranged = rearrangeString(s);

        if (rearranged.isEmpty()) {
            System.out.println("Not possible to rearrange: valid arrangement does not exist.");
        } else {
            System.out.println("Rearranged string (no two adjacent characters equal): " + rearranged);
        }

        sc.close();
    }
}
