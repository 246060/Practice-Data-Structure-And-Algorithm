package Baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

public class 동전_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coins = new int[n + 1];
        for (int i = 1; i <= n; i++)
            coins[i] = sc.nextInt();

        final int INF = (int) 1e9;
        int[] dp = new int[k + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= n; i++)
            for (int j = coins[i]; j <= k; j++)
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);

        if (dp[k] == INF)
            System.out.println(-1);
        else
            System.out.println(dp[k]);
    }
}
