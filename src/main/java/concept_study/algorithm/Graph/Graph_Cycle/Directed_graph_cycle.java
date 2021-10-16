package concept_study.algorithm.Graph.Graph_Cycle;

import java.util.ArrayList;
import java.util.Stack;

public class Directed_graph_cycle {
    // Note: 방향 그래프에서의 사이클 확인!!
    // https://hy38.github.io/finding-cycles-in-graph
    // https://nicotina04.tistory.com/148

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] finished;
    static int[] check;
    static int order, cycleCnt;
    static int[] parent;
    static Stack<Integer> st = new Stack<>();

    public static void main(String[] args) {

        int N = 7;
        int[][] edges = {{1, 2}, {1, 5}, {2, 3}, {2, 6}, {3, 4}, {6, 4}, {4, 7}, {7, 6}};

        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : edges)
            graph.get(edge[0]).add(edge[1]);

        finished = new boolean[N + 1];
        check = new int[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++)
            if (check[i] == 0)
                dfs(i);

        if (cycleCnt > 0) {
            System.out.println(cycleCnt + " 개의 사이클이 존재.");
        } else {
            System.out.println("사이클이 존재하지 않음.");
        }
    }

    static void dfs(int s) {
        // 몇 번째 방문인지 기록
        check[s] = ++order;

        for (int adj : graph.get(s)) {
            if (check[adj] == 0) {
                parent[adj] = s;
                dfs(adj);
            } else if (!finished[adj]) {
                st.clear();
                ++cycleCnt;
                trace(s, adj);
            }
            // else는 cross edge인 경우
        }

        // 해당 노드의 함수 호출이 종료되었음을 기록
        finished[s] = true;
    }

    static void trace(int s, int adj) {
        if (s == adj) {
            st.push(s);
            print();
            return;
        } else {
            st.push(s);
        }
        trace(parent[s], adj);
    }

    static void print() {
        while (!st.isEmpty()) {
            int node = st.pop();
            if (st.isEmpty()) {
                System.out.print(node);
            } else {
                System.out.print(node + " -> ");
            }
        }
        System.out.println();
    }

}
