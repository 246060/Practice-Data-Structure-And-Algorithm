package Baekjoon.dp;

import java.util.Scanner;

public class _2Xn_타일링_2 {
    // https://www.acmicpc.net/problem/11727
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        final int MOD = 10_007;

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % MOD;
        }

        System.out.println(dp[n]);
    }
}
