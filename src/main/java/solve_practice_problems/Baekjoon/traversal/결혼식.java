package solve_practice_problems.Baekjoon.traversal;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class 결혼식 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] graph = new int[n + 1][n + 1];

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int f = sc.nextInt();
            int t = sc.nextInt();
            graph[f][t] = 1;
            graph[t][f] = 1;
        }

        HashSet<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[n + 1];
        Stack<int[]> st = new Stack<>();

        st.push(new int[]{1, 0});
        visited[1] = true;

        while (!st.isEmpty()) {
            int[] cur = st.pop();
            int person = cur[0];
            int cnt = cur[1];

            for (int i = 0; i < graph[person].length; i++) {
                if (graph[person][i] == 1) {
                    if (!visited[i] && cnt + 1 <= 2) {
                        st.push(new int[]{i, cnt + 1});
                        visited[i] = true;
                        set.add(i);
                    }
                }
            }
        }

        System.out.println(set.size());
    }
}
