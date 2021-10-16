package solve_practice_problems.Baekjoon.dp;

import java.io.IOException;
import java.util.Scanner;

public class 가장_큰_정사각형 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int dp[][] = new int[1001][1001];
        int map[][] = new int[1001][1001];


        for (int i = 1; i <= n; i++) {
            String tmp = sc.nextLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = tmp.charAt(j - 1) - '0';
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] != 0) {
                    int imsi = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                    dp[i][j] = Math.min(dp[i][j - 1], imsi) + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        System.out.println(answer * answer);
    }
}
