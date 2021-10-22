package solve_practice_problems.LeetCode.dp;

import java.util.Arrays;

public class LeetCode_300_Longest_Increasing_Subsequence {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums) == 4);

        nums = new int[]{0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS(nums) == 4);

        nums = new int[]{7, 7, 7, 7, 7, 7, 7};
        System.out.println(lengthOfLIS(nums) == 1);

    }

    static public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max = Math.max(max, 1);
    }
}
