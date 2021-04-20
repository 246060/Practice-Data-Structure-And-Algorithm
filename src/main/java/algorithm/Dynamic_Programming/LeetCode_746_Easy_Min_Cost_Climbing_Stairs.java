package algorithm.Dynamic_Programming;

public class LeetCode_746_Easy_Min_Cost_Climbing_Stairs {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] cost1 = {10, 15, 20};
        // expected output = 15
        System.out.println(solution.minCostClimbingStairs(cost1) == 15);

        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        // expected output = 6
        System.out.println(solution.minCostClimbingStairs(cost2) == 6);
    }

    private static class Solution {

        public int minCostClimbingStairs(int[] cost) {
            // f(n) = min(f(n-1)+cost(n-1), f(n-2)+cost(n-2))

            int f1 = 0;
            int f2 = 0;
            int tmp;

            for (int i = 2; i <= cost.length; i++) {
                tmp = f2;
                f2 = Math.min(f1 + cost[i - 2], f2 + cost[i - 1]);
                f1 = tmp;
            }

            return f2;
        }
    }
}
