package solve_practice_problems.LeetCode.dp;

public class LeetCode_70_Easy_Climbing_Stairs {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int n1 = 2; // expected output = 2
        System.out.println(solution.climbStairs(n1) == 2);

        int n2 = 3; // expected output = 3
        System.out.println(solution.climbStairs(n2) == 3);
    }

    private static class Solution {
        // 점화식 :
        // f(1) = 1
        // f(2) = 2
        // f(n) = f(n-1) + f(n-2)

        public int climbStairs(int n) {

            int f1 = 1;
            int f2 = 2;
            int tmp;

            if (n == 1) return f1;
            if (n == 2) return f2;

            for (int i = 3; i <= n; i++) {
                tmp = f2;
                f2 = f1 + f2;
                f1 = tmp;
            }

            return f2;
        }
    }
}
