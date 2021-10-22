package solve_practice_problems.LeetCode.dp;

import java.util.Arrays;

public class LeetCode_45_Jump_Game2 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump1(nums) == 2);

        nums = new int[]{2, 3, 0, 1, 4};
        System.out.println(jump1(nums) == 2);


        nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(jump2(nums) == 2);

        nums = new int[]{2, 3, 0, 1, 4};
        System.out.println(jump2(nums) == 2);
    }

    // Time : O(N), Space : O(1)
    static public int jump2(int[] nums) {

        int n = nums.length;
        int end = 0, fastest = 0;
        int jump = 0;

        for (int i = 0; i < n - 1; i++) {
            fastest = Math.max(fastest, i + nums[i]);
            if (i == end) {
                jump++;
                end = fastest;
            }
        }

        return jump;
    }

    // Time : O(n^2), Space : O(n)
    static public int jump1(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;

            for (int j = i + 1; j <= Math.min(n - 1, i + nums[i]); j++) {
                min = Math.min(min, dp[j]);
            }

            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }

        return dp[0];
    }
}
