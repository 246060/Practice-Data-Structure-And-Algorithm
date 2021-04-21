package algorithm.Dynamic_Programming;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode_322_Medium_Coin_Change {
    // top-down 방식 풀이
    // bottom-up 으로 풀지 못했음.

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        // expected output = 3
        System.out.println(solution.coinChange(coins1, amount1) == 3);

        int[] coins2 = {2};
        int amount2 = 3;
        // expected output = -1
        System.out.println(solution.coinChange(coins2, amount2) == -1);

        int[] coins3 = {1};
        int amount3 = 0;
        // expected output = 0
        System.out.println(solution.coinChange(coins3, amount3) == 0);

        int[] coins4 = {1};
        int amount4 = 1;
        // expected output = 1
        System.out.println(solution.coinChange(coins4, amount4) == 1);

        int[] coins5 = {1};
        int amount5 = 2;
        // expected output = 2
        System.out.println(solution.coinChange(coins5, amount5) == 2);
    }

    // You are given an integer array coins representing coins of different denominations
    // and an integer amount representing a total amount of money.

    // Return the fewest number of coins that you need to make up that amount.
    // If that amount of money cannot be made up by any combination of the coins, return -1.

    // You may assume that you have an infinite number of each kind of coin.

    private static class Solution {
        // if n = 11, coins = {1, 2, 5}
        // f(11) = min(f(10),f(9),f(7))+1

        // 점화식
        // f(n) = min(f(n-1),f(n-2),f(n-5))+1

        private HashMap<Integer, Integer> memo;

        public int coinChange(int[] coins, int amount) {
            memo = new HashMap<>();
            return recursiveCoinChange(coins, amount);
        }

        private int recursiveCoinChange(int[] coins, int amount) {
            if (amount < 0) return -1;
            if (amount == 0) return 0;

            // memo
            if (memo.containsKey(amount))
                return memo.get(amount);

            int[] counts = new int[coins.length];
            int max = -1;

            for (int i = 0; i < coins.length; i++) {
                counts[i] = recursiveCoinChange(coins, amount - coins[i]);
                max = Math.max(max, counts[i]);
            }

            if (max == -1) {
                memo.put(amount, -1);
                return -1;
            }

            int answer = Arrays.stream(counts)
                               .filter(i -> i != -1)
                               .min()
                               .orElse(0);
            answer += 1;

            // memo
            memo.put(amount, answer);

            return answer;
        }
    }
}
