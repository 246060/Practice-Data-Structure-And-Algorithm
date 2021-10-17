package concept_study.algorithm.graph.Strongly_Connected_Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Kosaraju {

    static int[][] data = {
            {1, 2}, {2, 3}, {3, 1}, {4, 2}, {4, 5},
            {5, 7}, {6, 5}, {7, 6}, {8, 5}, {8, 9},
            {9, 10}, {10, 11}, {11, 3}, {11, 8}
    };

    static ArrayList<ArrayList<Integer>> digraph; // 방향 그래프
    static ArrayList<ArrayList<Integer>> rdigraph; // 역방향 그래프
    static ArrayList<ArrayList<Integer>> SCC;
    static boolean[] visited;
    static Stack<Integer> stack;

    public static void main(String[] args) {

        int N = 11;
        SCC = new ArrayList<>();

        digraph = new ArrayList<>();
        rdigraph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            digraph.add(new ArrayList<>());
            rdigraph.add(new ArrayList<>());
        }

        for (int[] edge : data) {
            digraph.get(edge[0]).add(edge[1]);
            rdigraph.get(edge[1]).add(edge[0]);
        }

        visited = new boolean[N + 1];
        stack = new Stack<>();

        // 방향 그래프에 대하여 dfs를 수행하고,
        // 탐색이 종료되는 점부터 스택에 push함.
        for (int i = 1; i < N + 1; i++)
            if (!visited[i])
                dfs(i);

        int group = 0;
        Arrays.fill(visited, false);

        // 역방향 그래프에 대하여 dfs룰 수행.
        while (!stack.isEmpty()) {
            int v = stack.pop();

            // 방문 체크된 것은 이미 start가 하나의 SCC 그룹에 속해 있다는 뜻.
            if (visited[v])
                continue;

            reDfs(v, group);
            group++;
        }

        // SCC의 갯수: 4
        // 1번째 SCC : [8, 9, 10, 11]
        // 2번째 SCC : [4]
        // 3번째 SCC : [5, 6, 7]
        // 4번째 SCC : [1, 2, 3]
        System.out.format("SCC의 갯수: %d\n", SCC.size());
        for (int i = 0; i < SCC.size(); i++) {
            System.out.format("%d번째 SCC : ", i + 1);
            System.out.println(SCC.get(i).stream().sorted().toList());
        }
    }

    static void reDfs(int v, int group) {
        visited[v] = true;

        if (SCC.size() != group + 1)
            SCC.add(new ArrayList<>());

        SCC.get(group).add(v);

        for (int adj : rdigraph.get(v))
            if (!visited[adj])
                reDfs(adj, group);
    }

    static void dfs(int v) {
        visited[v] = true;

        for (int adj : digraph.get(v))
            if (!visited[adj])
                dfs(adj);

        // post order
        stack.push(v);
    }
}
