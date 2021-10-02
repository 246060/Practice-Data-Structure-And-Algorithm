package algorithm.Dynamic_Programming;

import java.util.Scanner;

public class Baekjoon_1912 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int[] dp = new int[n];
        dp[0] = nums[0];

        int answer = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
