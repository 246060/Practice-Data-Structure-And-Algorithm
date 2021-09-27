package Coding_Test.Baekjoon.dp;

import java.math.BigInteger;
import java.util.Scanner;

public class 조합_2407 {
    // https://www.acmicpc.net/problem/2407

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        BigInteger[][] dp = new BigInteger[101][101];
        dp[1][0] = dp[1][1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    dp[i][j] = BigInteger.ONE;
                else {
                    dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
