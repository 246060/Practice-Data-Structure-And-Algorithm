package algorithm.Basic.Greedy;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Baekjoon_2583 {

    static int sum = 0;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] table = new int[M][N];

        for (int i = 0; i < K; i++) {
            int start_c = sc.nextInt();
            int start_r = sc.nextInt();
            int end_c = sc.nextInt();
            int end_r = sc.nextInt();

            for (int r = start_r; r < end_r; r++)
                for (int c = start_c; c < end_c; c++)
                    table[r][c] = 1;
        }

        for (int i = 0; i < table.length; i++)
            for (int j = 0; j < table[i].length; j++)
                if (table[i][j] != 1)
                    list.add(dfs(table, i, j));

        System.out.println(list.size());
        System.out.println(list.stream()
                               .sorted()
                               .map(String::valueOf)
                               .collect(Collectors.joining(" ")));
    }


    private static int dfs(int[][] table, int r, int c) {

        Stack<int[]> st = new Stack<>();
        st.push(new int[]{r, c});
        int count = 0;

        while (!st.isEmpty()) {
            int[] cur = st.pop();

            r = cur[0];
            c = cur[1];

            if (!isValid(table, r, c)) {
                continue;
            }

            table[r][c] = 1;
            count++;

            st.push(new int[]{r + 1, c});
            st.push(new int[]{r - 1, c});
            st.push(new int[]{r, c + 1});
            st.push(new int[]{r, c - 1});
        }

        return count;
    }

    private static boolean isValid(int[][] table, int r, int c) {

        if (r < 0 || c < 0 || r >= table.length || c >= table[r].length)
            return false;

        if (table[r][c] == 1)
            return false;

        return true;
    }
}
