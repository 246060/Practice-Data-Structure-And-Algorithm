package solve_practice_problems.LeetCode.dp;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_1137_N_th_Tribonacci_Number {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(tribonacci(n) == 4);

        n = 25;
        System.out.println(tribonacci(n) == 1389537);
    }

    static public int tribonacci(int n) {
        int[] dp = new int[38];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }
}
