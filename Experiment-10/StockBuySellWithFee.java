import java.util.Scanner;

public class StockBuySellWithFee {

    /**
     * Calculates the maximum profit obtainable from buying and selling stock with a transaction fee.
     * State machine DP:
     * - cash: maximum profit on current day if not holding any stock
     * - hold: maximum profit on current day if holding a share of stock
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    static long maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) return 0;

        long cash = 0;
        long hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            // cash = max(keep cash, sell today's stock and pay transaction fee)
            cash = Math.max(cash, hold + prices[i] - fee);
            // hold = max(keep holding, buy stock today)
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Best Time to Buy and Sell Stock with Transaction Fee ===");
        System.out.print("Enter number of days (size of prices array): ");
        int n = sc.nextInt();

        int[] prices = new int[n];
        System.out.println("Enter daily stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.print("Enter transaction fee: ");
        int fee = sc.nextInt();

        if (n == 0) {
            System.out.println("No prices provided. Maximum profit: 0");
        } else {
            long profit = maxProfit(prices, fee);
            System.out.println("Maximum Profit achievable: " + profit);
        }

        sc.close();
    }
}
