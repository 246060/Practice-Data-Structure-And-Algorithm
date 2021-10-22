package solve_practice_problems.LeetCode.dp;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_119_Triangle_2 {

    public static void main(String[] args) {
        int rowIndex = 3;
        System.out.println(getRow(rowIndex));

        rowIndex = 0;
        System.out.println(getRow(rowIndex));

        rowIndex = 1;
        System.out.println(getRow(rowIndex));
    }

    static public List<Integer> getRow(int rowIndex) {
        int n = rowIndex;
        int[][] triangle = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    triangle[i][j] = 1;
                } else if (j == 0) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j] + triangle[i][j - 1];
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0, j = n; i <= n; i++) {
            ans.add(triangle[j - i][i]);
        }
        return ans;
    }
}
