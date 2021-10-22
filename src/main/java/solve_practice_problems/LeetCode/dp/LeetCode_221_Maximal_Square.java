package solve_practice_problems.LeetCode.dp;

public class LeetCode_221_Maximal_Square {

    public static void main(String[] args) {

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalSquare(matrix) == 4);


        char[][] matrix2 = {{'0'}};
        System.out.println(maximalSquare(matrix2) == 0);
    }

    static public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i - 1][j - 1] == '1') {

                    int min = Integer.MAX_VALUE;
                    min = Math.min(min, dp[i - 1][j]);
                    min = Math.min(min, dp[i][j - 1]);
                    min = Math.min(min, dp[i - 1][j - 1]);

                    dp[i][j] = 1 + min;
                    max = Math.max(max, dp[i][j]);
                }

            }
        }

        return max * max;
    }

    static public int maximalSquare2(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int len = Math.min(n, m);

        out:
        for (; len > 0; len--) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= m - len; j++) {
                    if (traversal(len, matrix, i, j)) {
                        break out;
                    }
                }
            }
        }

        return len * len;
    }

    static boolean traversal(int len, char[][] matrix, int r, int c) {
        for (int i = r; i < r + len; i++) {
            for (int j = c; j < c + len; j++) {
                if (matrix[i][j] == '0') {
                    return false;
                }
            }
        }
        return true;
    }
}
