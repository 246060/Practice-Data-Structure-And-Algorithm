package concept_study.data_structure.Graph;

import java.util.Arrays;

public class Adjacency_Matrix {
    public static void main(String[] args) {

        final int INF = (int) 1e9; // 도달 할 수 없음 뜻함
        int N = 3;
        int[][] graph = new int[N + 1][N + 1];

        for (int source = 0; source < graph.length; source++) {
            for (int dest = 0; dest < graph[source].length; dest++) {

                if (source == dest) {
                    graph[source][dest] = 0;
                } else {
                    graph[source][dest] = INF;
                }
            }
        }

        graph[1][2] = 4; // 연결: 1 -> 2 , 비용: 4
        graph[1][3] = 5; // 연결: 1 -> 3 , 비용: 5
        graph[2][3] = 2; // 연결: 2 -> 3 , 비용: 2

        for (int[] edge : graph) {
            System.out.println(Arrays.toString(edge));
        }
    }
}
