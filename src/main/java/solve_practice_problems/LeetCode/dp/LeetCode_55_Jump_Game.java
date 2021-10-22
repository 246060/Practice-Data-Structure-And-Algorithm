package solve_practice_problems.LeetCode.dp;

public class LeetCode_55_Jump_Game {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums) == true);

        nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(canJump(nums) == false);

        nums = new int[]{2, 5, 0, 0};
        System.out.println(canJump(nums) == true);

        nums = new int[]{3, 0, 8, 2, 0, 0, 1};
        System.out.println(canJump(nums) == true);
    }

    static public boolean canJump(int[] nums) {
        int maxIdx = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == 0 && maxIdx <= i) {
                return false;
            }
            maxIdx = Math.max(maxIdx, i + nums[i]);
        }

        return true;
    }
}
