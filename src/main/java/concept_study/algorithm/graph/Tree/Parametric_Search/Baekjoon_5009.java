package concept_study.algorithm.graph.Tree.Parametric_Search;

import java.util.ArrayList;

public class Baekjoon_5009 {
    public static void main(String[] args) {

        int n = 6;
        int[][] table = {
                {0, 2, 3, 4, 5, 6},
                {0, 1, 3, 4, 5, 6},
                {1, 6, 5, 4, 2, 1},
                {2, 6, 5, 3, 2, 1},
                {1, 1, 2, 3, 4, 6},
                {2, 1, 2, 3, 4, 5},
        };

        int answer = Integer.MAX_VALUE;
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(table, n, mid)) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static boolean isPossible(int[][] table, int n, int t) {

        for (int i = 0; i < table.length; i++) {

        }

        return true;
    }

    static boolean recursive(int[][] table, int index, int t, ArrayList<Integer> list) {
        if (list.size() > t) {
            return false;
        }

        for (int i = index; i < table.length; i++) {
            int teacher = table[i][0];
            if (i == teacher)
                continue;

        }
        return true;
    }

}
