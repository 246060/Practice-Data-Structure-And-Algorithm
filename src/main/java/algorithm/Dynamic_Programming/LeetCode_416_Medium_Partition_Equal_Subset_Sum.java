package algorithm.Dynamic_Programming;

import java.util.Arrays;

public class LeetCode_416_Medium_Partition_Equal_Subset_Sum {

    /*
     * Given a non-empty array nums containing only positive integers,
     * find if the array can be partitioned into two subsets
     * such that the sum of elements in both subsets is equal.
     * */
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums1 = {1, 5, 11, 5};
        // expected output = true
        System.out.println(solution.canPartition(nums1));

        int[] nums2 = {1, 2, 3, 5};
        // expected output = false
        System.out.println(solution.canPartition(nums2));

    }

    private static class Solution {

        public boolean canPartition(int[] nums) {

            int sum = Arrays.stream(nums).sum();
            if (sum % 2 == 1)
                return false;

            int subSetSum = sum / 2;

            int[] nums2 = new int[nums.length + 1];
            System.arraycopy(nums, 0, nums2, 1, nums.length);
            nums = nums2;

            boolean[][] matrix = new boolean[nums.length][subSetSum + 1];
            for (int i = 0; i < nums.length; i++) matrix[i][0] = true;

            boolean answer = false;
            for (int r = 1; r < nums.length; r++) {
                for (int c = 1; c < matrix[r].length; c++) {

                    boolean leafOne = matrix[r - 1][c];
                    boolean leafTwo = false;

                    if (c - nums[r] >= 0)
                        leafTwo = matrix[r - 1][c - nums[r]];

                    matrix[r][c] = leafOne || leafTwo;
                    answer = matrix[r][c];
                }
            }

            return answer;
        }
    }
}
