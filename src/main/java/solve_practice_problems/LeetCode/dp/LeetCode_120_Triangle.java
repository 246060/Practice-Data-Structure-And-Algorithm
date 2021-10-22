package solve_practice_problems.LeetCode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_120_Triangle {
    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            triangle.add(new ArrayList<>());
        }
        triangle.get(0).add(2);
        triangle.get(1).add(3);
        triangle.get(1).add(4);
        triangle.get(2).add(6);
        triangle.get(2).add(5);
        triangle.get(2).add(7);
        triangle.get(3).add(4);
        triangle.get(3).add(1);
        triangle.get(3).add(8);
        triangle.get(3).add(3);

        System.out.println(minimumTotal(triangle) == 11);


        triangle.clear();
        triangle.add(new ArrayList<>());
        triangle.get(0).add(-10);
        System.out.println(minimumTotal(triangle) == -10);


        // [[-1],[2,3],[1,-1,-3]]
        triangle.clear();
        triangle.add(new ArrayList<>());
        triangle.add(new ArrayList<>());
        triangle.add(new ArrayList<>());

        triangle.get(0).add(-1);
        triangle.get(1).add(2);
        triangle.get(1).add(3);
        triangle.get(2).add(1);
        triangle.get(2).add(-1);
        triangle.get(2).add(-3);

        System.out.println(minimumTotal(triangle) == -1);
    }

    static public int minimumTotal(List<List<Integer>> triangle) {
        final int INF = (int) 1e9;
        int n = triangle.size();

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }

        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int v = triangle.get(i).get(j);
                dp[i][j] = Math.min(dp[i][j], v + dp[i + 1][j]);
                dp[i][j] = Math.min(dp[i][j], v + dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];
    }
}
