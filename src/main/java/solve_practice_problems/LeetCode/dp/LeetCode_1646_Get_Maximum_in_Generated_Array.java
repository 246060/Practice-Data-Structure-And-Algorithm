package solve_practice_problems.LeetCode.dp;

import java.util.Arrays;

public class LeetCode_1646_Get_Maximum_in_Generated_Array {

    public static void main(String[] args) {

        int n = 7;
        System.out.println(getMaximumGenerated(n));

        n = 2;
        System.out.println(getMaximumGenerated(n));

        n = 3;
        System.out.println(getMaximumGenerated(n));
    }

    static public int getMaximumGenerated(int n) {
        if (n == 0)
            return 0;

        int[] nums = new int[n + 1];
        nums[1] = 1;

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (2 * i <= n) {
                nums[2 * i] = nums[i];
                max = Math.max(max, nums[2 * i]);
            }

            if (2 * i + 1 <= n) {
                nums[2 * i + 1] = nums[i] + nums[i + 1];
                max = Math.max(max, nums[2 * i + 1]);
            }
        }

        if (max == Integer.MIN_VALUE) {
            return Arrays.stream(nums).max().getAsInt();
        } else {
            return max;
        }
    }
}
