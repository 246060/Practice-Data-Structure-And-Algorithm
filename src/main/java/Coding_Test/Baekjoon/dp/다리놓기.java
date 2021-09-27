package Coding_Test.Baekjoon.dp;

import java.util.Scanner;

public class 다리놓기 {
    public static void main(String[] args) {
        // https://www.acmicpc.net/problem/1010

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] dp = new int[31][31];
            dp[1][0] = dp[1][1] = 1;

            for (int j = 2; j <= M; j++)
                for (int k = 0; k <= j; k++)
                    if (k == 0 || k == j)
                        dp[j][k] = 1;
                    else
                        dp[j][k] = dp[j - 1][k - 1] + dp[j - 1][k];

            System.out.println(dp[M][N]);
        }
    }
}
