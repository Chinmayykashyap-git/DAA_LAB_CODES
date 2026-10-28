import java.util.Scanner;

public class AllocateMinimumPages {

    /**
     * Helper method to verify if it is possible to allocate books to m students
     * such that no student receives more than maxPagesAllowed.
     */
    static boolean isPossible(int[] pages, int n, int m, long maxPagesAllowed) {
        int studentsRequired = 1;
        long currentPagesAllocated = 0;

        for (int i = 0; i < n; i++) {
            // A single book has more pages than allowed limit
            if (pages[i] > maxPagesAllowed) {
                return false;
            }

            if (currentPagesAllocated + pages[i] > maxPagesAllowed) {
                // Allocate to next student
                studentsRequired++;
                currentPagesAllocated = pages[i];

                if (studentsRequired > m) {
                    return false;
                }
            } else {
                currentPagesAllocated += pages[i];
            }
        }

        return true;
    }

    /**
     * Finds the minimum possible value of the maximum pages allocated to any student.
     * Uses Binary Search on the answer space [max(pages), sum(pages)].
     * Time Complexity: O(n * log(sum - max))
     * Space Complexity: O(1)
     */
    static long findPages(int[] pages, int n, int m) {
        // If students are more than number of books, allocation is impossible
        if (m > n || n == 0 || m <= 0) {
            return -1;
        }

        long low = 0;
        long high = 0;

        for (int p : pages) {
            low = Math.max(low, p);
            high += p;
        }

        long result = -1;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (isPossible(pages, n, m, mid)) {
                result = mid; // Feasible, try to minimize further
                high = mid - 1;
            } else {
                low = mid + 1; // Not feasible, increase allowed capacity
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books (N): ");
        int n = sc.nextInt();

        int[] pages = new int[n];
        System.out.println("Enter number of pages in each book:");
        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        System.out.print("Enter number of students (M): ");
        int m = sc.nextInt();

        long minMaxPages = findPages(pages, n, m);

        if (minMaxPages == -1) {
            System.out.println("Allocation not possible (students exceed books or invalid input).");
        } else {
            System.out.println("Minimum possible maximum pages allocated to a student: " + minMaxPages);
        }

        sc.close();
    }
}
