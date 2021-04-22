package algorithm.Dynamic_Programming;

import java.util.Arrays;

public class LeetCode_152_Medium_Maximum_Product_Subarray {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums1 = {2, 3, -2, 4};
        // expected output = 6
        System.out.println(solution.maxProduct(nums1) == 6);

        int[] nums2 = {-2, 0, -1};
        // expected output = 0
        System.out.println(solution.maxProduct(nums2) == 0);

        int[] nums3 = {-2, 3, -4};
        // expected output = 24
        System.out.println(solution.maxProduct(nums3) == 24);

        int[] nums4 = {3, -2, 1, 0, -8, -9};
        // expected output = 24
        System.out.println(solution.maxProduct(nums4) == 72);
    }

    private static class Solution {

        public int maxProduct(int[] nums) {
            // f_min(n) = min(f_min(n-1)*n, f_max(n-1)*n, n)
            // f_max(n) = max(f_min(n-1)*n, f_max(n-1)*n, n)
            int answer = nums[0];
            int min = nums[0];
            int max = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0) {
                    min = 0;
                    max = 0;
                } else {
                    int tmp = Math.min(nums[i], Math.min(min * nums[i], max * nums[i]));
                    max = Math.max(nums[i], Math.max(min * nums[i], max * nums[i]));
                    min = tmp;
                }
                answer = Math.max(max, answer);
            }
            return answer;
        }
    }
}
