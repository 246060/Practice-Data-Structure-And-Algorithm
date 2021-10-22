package solve_practice_problems.LeetCode.dp;

public class LeetCode_62_Unique_Paths_2 {

    public static void main(String[] args) {

        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid) == 2);

        int[][] obstacleGrid2 = {{0, 1}, {0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid2) == 1);

    }

    static public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] map = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break;
            map[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) break;
            map[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;

                if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 1) {
                    map[i][j] = 0;

                } else if (obstacleGrid[i - 1][j] == 1) {
                    map[i][j] = map[i][j - 1];

                } else if (obstacleGrid[i][j - 1] == 1) {
                    map[i][j] = map[i - 1][j];

                } else {
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                }
            }
        }

        return map[m - 1][n - 1];
    }
}
