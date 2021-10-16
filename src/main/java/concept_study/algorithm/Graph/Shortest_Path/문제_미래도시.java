package concept_study.algorithm.Graph.Shortest_Path;

import java.util.Arrays;

/*
 * # 입력 조건
 * 첫째 줄에 전체 회사의 개수 N과 경로의 개수 M이 공백으로 구분되어 차례대로 주어진다.
 * (1<=N,M<=100)
 * 둘째 줄부터 M+1번째 줄에는 연결된 두 회사의 번호가 공백으로 구분되어 주어진다.
 * M+2 번째 줄에는 X와 K가 공백으로 구분되어 차례대로 주어진다.(1<=K<=100)
 *
 * # 출력 조건
 * 첫째 줄에 방문 판매원 A가 1번에서 출발하여 K번 회사를 거쳐 X번 회사로 가는 최소 이동 시간을 출력한다.
 * 만약 X번 회사에 도달할 수 없다면 -1 을 출력한다.
 *
 * # 입력 예시
 * 5 7
 * 1 2
 * 1 3
 * 1 4
 * 2 4
 * 3 4
 * 3 5
 * 4 5
 * 4 5
 *
 * # 출력 예시
 * 3
 * */
public class 문제_미래도시 {

    public static void main(String[] args) {
        int N = 5, M = 7;
        int[][] edges = {
                {1, 2},
                {1, 3},
                {1, 4},
                {2, 4},
                {3, 4},
                {3, 5},
                {4, 5}
        };

        int X = 4, K = 5;

        int INF = (int) 1e9;
        int[][] graph = new int[N + 1][N + 1];

        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], INF);

            for (int j = 0; j < graph[i].length; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = INF;
                }
            }
        }

        for (int[] edge : edges) {
            int source = edge[0];
            int dest = edge[1];
            graph[source][dest] = 1;
            graph[dest][source] = 1;
        }

        for (int k = 1; k < N + 1; k++)
            for (int s = 1; s < N + 1; s++)
                for (int d = 1; d < N + 1; d++)
                    graph[s][d] = Math.min(graph[s][d], graph[s][k] + graph[k][d]);

        int distance = graph[1][K] + graph[K][X];
        if (distance >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(distance);
        }
    }
}
