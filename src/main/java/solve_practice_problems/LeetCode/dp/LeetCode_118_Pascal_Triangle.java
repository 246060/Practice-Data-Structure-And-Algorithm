package solve_practice_problems.LeetCode.dp;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_118_Pascal_Triangle {

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));

        numRows = 1;
        System.out.println(generate(numRows));
    }

    static public List<List<Integer>> generate(int numRows) {

        int[][] map = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {
                if (i == 0 || j == 0) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                tmp.add(map[i - j][j]);
            }
            ans.add(tmp);
        }

        return ans;
    }
}
