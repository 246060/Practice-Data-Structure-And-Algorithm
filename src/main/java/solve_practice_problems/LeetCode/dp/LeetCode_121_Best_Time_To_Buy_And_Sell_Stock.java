package solve_practice_problems.LeetCode.dp;

public class LeetCode_121_Best_Time_To_Buy_And_Sell_Stock {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));

        prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices));
    }

    static public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0, min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(max, prices[i] - min);
            }
        }

        return max;
    }

    // 시간 초과
    static public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[] map = new int[n];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < prices.length; j++) {
                map[j] = prices[j] - prices[i];
                max = Integer.max(max, map[j]);
            }
        }

        return max;
    }
}
