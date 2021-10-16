package solve_practice_problems.Baekjoon.dp;

import java.util.Scanner;

public class 돌_게임_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean[] dp = new boolean[7];
        dp[0] = false;
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        dp[4] = true;
        dp[5] = true;
        dp[6] = true;

        System.out.println(dp[n % 7] ? "SK" : "CY");
    }
}
