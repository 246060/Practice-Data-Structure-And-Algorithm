package solve_practice_problems.Baekjoon.traversal;

import java.util.*;

public class 작업 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList();
        }
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            graph[e].add(s);
        }

        boolean[] visited = new boolean[n + 1];
        Stack<Integer> st = new Stack<>();
        int cnt = 0;

        int start = sc.nextInt();
        st.push(start);
        visited[start] = true;

        while (!st.isEmpty()) {
            int cur = st.pop();

            for (int adj : graph[cur]) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    st.push(adj);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
