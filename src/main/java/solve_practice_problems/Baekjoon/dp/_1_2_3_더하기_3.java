package solve_practice_problems.Baekjoon.dp;

import java.util.Scanner;

public class _1_2_3_더하기_3 {

    public static void main(String[] args) {
        final int MOD = 1_000_000_009;

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            long[] dp = new long[1_000_001];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int j = 4; j <= n; j++) {
                dp[j] = (dp[j - 3] + dp[j - 2] + dp[j - 1]) % MOD;
            }

            System.out.println(dp[n]);
        }
    }
}
