package solve_practice_problems.LeetCode.dp;

import java.util.Arrays;

public class LeetCode_673_Number_of_Longest_Increasing_Subsequence {

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 4, 7};
        System.out.println(findNumberOfLIS(nums) == 2);

        nums = new int[]{2, 2, 2, 2, 2};
        System.out.println(findNumberOfLIS(nums) == 5);

        nums = new int[]{1};
        System.out.println(findNumberOfLIS(nums) == 1);
    }

    static public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnts = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(cnts, 1);

        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        cnts[i] = cnts[j];
                    } else if (dp[i] == dp[j] + 1) {
                        cnts[i] += cnts[j];
                    }
                }
            }

            max = Math.max(max, dp[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                ans += cnts[i];
            }
        }

        return ans;
    }
}
