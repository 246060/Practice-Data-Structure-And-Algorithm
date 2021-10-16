package concept_study.algorithm.Graph.Shortest_Path;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * # 입력 조건
 * 첫째 줄에 도시의 개수 N, 통로의 개수 M, 메시지를 보내고자 하는 도시 C 가 주어진다.
 * (1<= N <= 30_000, 1<= M <= 200_000, 1<= C <= N)
 * 둘째 줄부터 M+1 번째 줄에 걸쳐서 통로에 대한 정보 X, Y, Z 가 주어진다. 이는 특정 도시 X에서 다른 특정 도시 Y로 이어지는 통로가 있으며,
 * 메시지가 전달되는 시간이 Z라는 의미다.
 * (1<=X, Y<=N, 1<=Z<=1_000)
 *
 * # 출력 조건
 * 첫째 줄에 도시 C에서 보낸 메시지를 받는 도시의 총 개수와 총 걸리는 시간을 공백으로 구분하여 출력한다.
 *
 * # 입력 예시
 * 3 2 1
 * 1 2 4
 * 1 3 2
 *
 * # 출력 예시
 * 2 4
 * */
public class 문제_전보 {

    public static void main(String[] args) {

        int N = 3, M = 2, C = 1;
        int[][] edgeInput = {{1, 2, 4}, {1, 3, 2}};

        int INF = (int) 1e9;
        int[][] edges = new int[N + 1][N + 1];
        for (int i = 1; i < edges.length; i++) {
            for (int j = 1; j < edges[i].length; j++) {
                if (i == j) edges[i][j] = 0;
                else edges[i][j] = INF;
            }
        }

        for (int[] edge : edgeInput) {
            int source = edge[0];
            int dest = edge[1];
            int cost = edge[2];
            edges[source][dest] = cost;
        }

        int[] distance = new int[N + 1];
        Arrays.fill(distance, INF);
        distance[C] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v[1]));
        pq.offer(new int[]{C, distance[C]});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int source = node[0];
            int dist = node[1];

            if (distance[source] < dist) {
                continue;
            }

            // adj는 도착지점
            for (int dest = 1; dest <= N; dest++) {
                if (source == dest || edges[source][dest] == INF)
                    continue;

                int cost = distance[source] + edges[source][dest];

                if (cost < distance[dest]) {
                    distance[dest] = cost;
                    pq.offer(new int[]{dest, cost});
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] != INF && distance[i] != 0) {
                count++;
                max = Math.max(max, distance[i]);
            }
        }

        System.out.println(count + " " + max);
    }
}
