package solve_practice_problems.LeetCode.dp;

public class LeetCode_62_Unique_Paths {

    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(uniquePaths(m, n) == 28);

        m = 3;
        n = 2;
        System.out.println(uniquePaths(m, n) == 3);

        m = 7;
        n = 3;
        System.out.println(uniquePaths(m, n) == 28);
    }

    static public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    paths[i][j] = 1;
                } else {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }

        return paths[m - 1][n - 1];
    }
}
