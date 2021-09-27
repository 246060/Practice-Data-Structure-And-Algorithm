package Coding_Test.Baekjoon.dp.LIS;

import java.util.Scanner;

public class 가장_큰_증가_부분_수열 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int[] dp = new int[N];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            dp[i] = arr[i];

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
