package solve_practice_problems.LeetCode.dp;

import java.util.Arrays;

public class LeetCode_53_Easy_Maximum_Subarray {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // expected output = 6
        System.out.println(solution.maxSubArray(nums1) == 6);

        int[] nums2 = {1};
        // expected output = 1
        System.out.println(solution.maxSubArray(nums2) == 1);

        int[] nums3 = {5, 4, -1, 7, 8};
        // expected output = 23
        System.out.println(solution.maxSubArray(nums3) == 23);
    }

    private static class Solution {
        // f(n) | f(n-1) + n
        //      | n  & start index 변경

        public int maxSubArray(int[] nums) {

            int n = nums.length;
            int[] memo = new int[n];
            memo[0] = nums[0];

            int start = 0;
            for (int i = 1; i < n; i++) {
                if (memo[i - 1] + nums[i] < nums[i]) {
                    memo[i] = nums[i];
                    start = i;
                } else {
                    memo[i] = memo[i - 1] + nums[i];
                }
            }

            // --------------------------------------------------------
            // 해당 sub array를 구해야되면?
            int MAX = Integer.MIN_VALUE;
            int end = 0;

            for (int i = 0; i < n; i++) {
                if (MAX < memo[i]) {
                    MAX = memo[i];
                    end = i;
                }
            }

            System.out.println(Arrays.toString(Arrays.copyOfRange(nums, start, end + 1)));
            // --------------------------------------------------------

            return Arrays.stream(memo).max().orElse(0);
        }
    }
}
