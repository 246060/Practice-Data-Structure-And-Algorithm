package algorithm.Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_11057 {
// 오르막 수

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] dp = new int[N + 1][10];

        for (int i = 0; i < 10; i++)
            dp[1][i] = 1;

        for (int i = 2; i < N + 1; i++)
            for (int j = 0; j < 10; j++)
                for (int k = 0; k <= j; k++)
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10_007;

        int answer = 0;
        for (int i = 0; i < dp[N].length; i++)
            answer = (answer + dp[N][i]) % 10_007;

        System.out.println(answer);
    }
}
