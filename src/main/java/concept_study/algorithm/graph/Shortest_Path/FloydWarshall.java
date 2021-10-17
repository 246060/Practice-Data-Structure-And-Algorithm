package concept_study.algorithm.graph.Shortest_Path;

import java.util.Arrays;

public class FloydWarshall {
    // 모든 정점을 시작으로 하여 최단거리 구하는 방법
    // 정점이 보통 500이하로 주어짐.
    // 시간 복잡도 O(n^3)
    // 다이나믹 프로그래밍 기법 중 하나

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
                {1, 2, 2},
                {1, 3, 5},
                {1, 4, 1},
                {2, 3, 3},
                {2, 4, 2},
                {3, 2, 3},
                {3, 6, 5},
                {4, 3, 3},
                {4, 5, 1},
                {5, 3, 1},
                {5, 6, 2},
        };

        process(edges, n);
    }

    static void process(int[][] edges, int n) {

        final int INF = (int) 1e9;

        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i < graph.length; i++)
            for (int j = 1; j < graph[i].length; j++)
                graph[i][j] = i == j ? 0 : INF;

        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            int cost = edge[2];

            graph[source][destination] = cost;
        }

        print(graph);

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    // 점화식 : k를 거쳐가면 더 적은 비용인지
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        print(graph);
    }

    static void print(int[][] graph) {
        for (int[] row : graph)
            System.out.println(Arrays.toString(row));

        System.out.println();
        System.out.println();
    }
}
