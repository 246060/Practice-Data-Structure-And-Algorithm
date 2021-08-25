package algorithm.Graph.Shortest_Path;

import java.util.Arrays;


public class BellmanFord {

    public static void main(String[] args) {
        int V = 8, E = 14;
        int[][] graph = new int[V + 1][V + 1];
        initGraph(graph);

        graph[1][2] = 8;
        graph[1][3] = 9;
        graph[1][5] = 11;
        graph[2][4] = 10;
        graph[3][2] = -15;
        graph[3][4] = 1;
        graph[3][5] = 3;
        graph[4][8] = 2;
        graph[5][6] = 8;
        graph[5][7] = 8;
        graph[6][7] = -7;
        graph[7][3] = 12;
        graph[7][8] = 5;
        graph[8][6] = 4;

        // 음수 사이클 확인
        System.out.println(solution(graph, 1));
    }

    static void initGraph(int[][] graph) {
        int INF = (int) 1e9;
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph[i].length; j++) {
                if (i == j) graph[i][j] = 0;
                else graph[i][j] = INF;
            }
        }
    }

    static boolean solution(int[][] graph, int start) {
        final int INF = (int) 1e9;
        int V = graph.length - 1;
        int[] distance = new int[V + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        boolean isUpdate;
        // V 노드 개수
        // 최소거리 최대 간선 개수 : V-1
        // V-1만 검사하면 최단 거리를 구할 수 있음.
        // (V-1)+1 번째 부터 relax 연산이 수행되면 음수 간선 순환이 존재함을 판단 할 수 있음.
        // 시간 복잡도 : O(VE)


        // 노드의 개수로 간선 확인 수 제한 ----------------------------------------------------
        for (int i = 1; i <= V; i++) {
            isUpdate = false;

            for (int from = 1; from <= V; from++) {

                // 제외 처리: 타켓 대상은 최단거리 테이블에서 INF 이면 안됨
                if (distance[from] == INF)
                    continue;

                // 간선 확인 ----------------------------------------------------
                // relax 하기 위한 loop
                for (int to = 1; to < graph[from].length; to++) {

                    // 간선 존재 확인 : 자기 자신이거나 간선이 없는 것은 제외
                    if (graph[from][to] == 0 || graph[from][to] == INF)
                        continue;

                    // relax : 최단거리 좁히는 연산
                    if (distance[to] > distance[from] + graph[from][to]) {
                        distance[to] = distance[from] + graph[from][to];
                        isUpdate = true;
                    }
                }
            }

            // V-1 번째에도 업데이트가 되었다면 그래프에 음수 간선 순환이 존재함을 판단
            if (i == V && isUpdate) {
                // 음수 간선 순환 존재
                return true;
            }
        }

        return false;
    }
}
