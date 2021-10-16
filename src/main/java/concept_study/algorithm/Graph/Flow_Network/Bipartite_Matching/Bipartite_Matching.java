package concept_study.algorithm.Graph.Flow_Network.Bipartite_Matching;

import java.util.Arrays;

public class Bipartite_Matching {
    // Maximum Bipartite Matching (MBP) Problem
    // https://www.geeksforgeeks.org/maximum-bipartite-matching/

    static final int INF = (int) 1e9;

    public static void main(String[] args) {
        // Source -> N(applicants) -> M(jobs) -> Destination

        final int N = 3; // N is number of applicants
        final int M = 3; // M is number of jobs

        int[][] graph = new int[N + 1][M + 1];
        for (int[] edge : graph)
            Arrays.fill(edge, INF);

        graph[1][1] = 1;
        graph[1][2] = 1;
        graph[1][3] = 1;
        graph[2][1] = 1;
        graph[3][2] = 1;

        int[] match = new int[M + 1];
        Arrays.fill(match, -1);

        int result = 0;
        for (int u = 1; u < N + 1; u++) {
            boolean[] visited = new boolean[M + 1];

            if (dfs(graph, u, visited, match))
                result++;
        }

        System.out.println("Possible Total Match : " + result);

        for (int i = 1; i < M + 1; i++)
            if (match[i] != -1)
                System.out.format("Match : %d -> %d\n", match[i], i);
    }

    static boolean dfs(int[][] graph, int u, boolean[] visited, int[] match) {

        for (int v = 1; v < graph[u].length; v++) {
            if (graph[u][v] != INF && !visited[v]) {
                visited[v] = true;

                // u -> v 가 서로 연결 되어 있으면서 dfs 방문이 아직 되지 않은것 중에
                // v가 아직 매칭되지 않앗거나, 이미 매칭 되어있다면 매칭 vertex를 재조정 진행
                if (match[v] < 0 || dfs(graph, match[v], visited, match)) {
                    match[v] = u;
                    return true;
                }
            }
        }

        return false;
    }

}
