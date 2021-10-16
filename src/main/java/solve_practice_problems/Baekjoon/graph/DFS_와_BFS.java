package solve_practice_problems.Baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DFS_와_BFS {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        boolean[][] graph = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = graph[b][a] = true;
        }

        dfs(graph, N, V);
        System.out.println();
        bfs(graph, N, V);
    }

    static void dfs(boolean[][] graph, int N, int start) {
        boolean[] visited = new boolean[N + 1];
        Stack<Integer> st = new Stack<>();
        st.push(start);

        while (!st.isEmpty()) {
            int v = st.pop();

            if (!visited[v]) {
                visited[v] = true;
                System.out.print(v + " ");

                for (int i = N; i > 0; i--) {
                    if (graph[v][i] && !visited[i]) {
                        st.push(i);
                    }
                }
            }
        }
    }

    static void bfs(boolean[][] graph, int N, int start) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int v = q.poll();
            System.out.print(v + " ");

            for (int i = 1; i <= N; i++) {
                if (graph[v][i] && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

}
