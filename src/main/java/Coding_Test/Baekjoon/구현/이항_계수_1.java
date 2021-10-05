package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 이항_계수_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(binomial_coefficient(N, K));
    }

    static int binomial_coefficient(int n, int k) {

        int[][] memo = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) memo[i][0] = 1;
        for (int i = 0; i <= n; i++) memo[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                memo[i][j] = memo[i - 1][j] + memo[i - 1][j - 1];
            }
        }

        return memo[n][k];
    }

}
