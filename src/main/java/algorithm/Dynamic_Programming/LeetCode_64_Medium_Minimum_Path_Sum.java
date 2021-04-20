package algorithm.Dynamic_Programming;

public class LeetCode_64_Medium_Minimum_Path_Sum {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[][] grid1 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        // expected output = 7
        System.out.println(solution.minPathSum(grid1) == 7);

        int[][] grid2 = {{1, 2, 3}, {4, 5, 6}};
        // expected output = 12
        System.out.println(solution.minPathSum(grid2) == 12);
    }

    // Note: You can only move either down or right at any point in time.
    // f(x,y) = cost(x,y) + Min(f(x-1, y), f(x, y-1))
    private static class Solution {

        public int minPathSum(int[][] grid) {

            int[][] answer = new int[grid.length][grid[0].length];

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (i == 0 && j == 0) {
                        answer[i][j] = grid[i][j];
                    } else if (i == 0) {
                        answer[i][j] = grid[i][j] + answer[i][j - 1];
                    } else if (j == 0) {
                        answer[i][j] = grid[i][j] + answer[i - 1][j];
                    } else {
                        answer[i][j] = grid[i][j] + Math.min(answer[i - 1][j], answer[i][j - 1]);
                    }
                }
            }

            return answer[answer.length - 1][answer[0].length - 1];
        }
    }
}
