package solve_practice_problems.LeetCode.dp;

public class LeetCode_518_Medium_Coin_Change_2 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] coins1 = {1, 2, 5};
        int amount1 = 5;
        // expected output = 4
        System.out.println(solution.change(amount1, coins1) == 4);

        int[] coins2 = {2};
        int amount2 = 3;
        // expected output = 0
        System.out.println(solution.change(amount2, coins2) == 0);

        int[] coins3 = {10};
        int amount3 = 10;
        // expected output = 1
        System.out.println(solution.change(amount3, coins3) == 1);


        int[] coins4 = {7};
        int amount4 = 0;
        // expected output = 1
        System.out.println(solution.change(amount4, coins4) == 1);
    }


    private static class Solution {

        public int change(int amount, int[] coins) {
            // 동전도 없는 경우를 추가
            int[] coins2 = new int[coins.length + 1];
            System.arraycopy(coins, 0, coins2, 1, coins.length);
            coins = coins2;

            int[][] matrix = new int[coins.length][amount + 1];
            // 초기화 - 1행 = 0 , 1열 = 1, 1행 1열 = 1
            for (int i = 0; i < coins.length; i++)
                matrix[i][0] = 1;

            for (int r = 1; r < coins.length; r++) {
                for (int c = 1; c < matrix[r].length; c++) {

                    int subProblemOne = matrix[r - 1][c];
                    int subProblemTwo = 0;
                    if (c - coins[r] >= 0)
                        subProblemTwo = matrix[r][c - coins[r]];

                    matrix[r][c] = subProblemOne + subProblemTwo;
                }
            }

            int rowLastIdx = matrix.length - 1;
            int colLastIdx = matrix[rowLastIdx].length - 1;
            return matrix[rowLastIdx][colLastIdx];
        }
    }
}
