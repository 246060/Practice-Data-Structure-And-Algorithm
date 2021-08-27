package algorithm.Graph.DFS_BFS;

import java.util.*;
import java.util.stream.Collectors;

public class Baekjoon_1260 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        for (int i = 0; i < N + 1; i++) {
            graph.get(i).sort(Integer::compareTo);
        }

        dfs(graph, N, V);
        bfs(graph, N, V);
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, int N, int V) {
        boolean[] visited = new boolean[N + 1];
        Stack<Integer> st = new Stack<>();
        st.push(V);

        ArrayList<Integer> answer = new ArrayList<>();
        while (!st.isEmpty()) {
            int cur = st.pop();

            if (visited[cur]) continue;
            visited[cur] = true;
            answer.add(cur);

            for (int i = graph.get(cur).size() - 1; i >= 0; i--) {
                if (visited[graph.get(cur).get(i)]) continue;
                st.push(graph.get(cur).get(i));
            }
        }

        System.out.println(answer.stream()
                                 .map(String::valueOf)
                                 .collect(Collectors.joining(" ")));
    }

    static void bfs(ArrayList<ArrayList<Integer>> graph, int N, int V) {

        boolean[] visited = new boolean[N + 1];
        Queue<Integer> pq = new LinkedList<>();
        pq.offer(V);

        ArrayList<Integer> answer = new ArrayList<>();
        while (!pq.isEmpty()) {
            int cur = pq.poll();

            if (visited[cur]) continue;
            visited[cur] = true;
            answer.add(cur);

            for (Integer adj : graph.get(cur)) {
                if (visited[adj]) continue;
                pq.offer(adj);
            }
        }

        System.out.println(answer.stream()
                                 .map(String::valueOf)
                                 .collect(Collectors.joining(" ")));
    }
}
