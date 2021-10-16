package concept_study.algorithm.Graph.Shortest_Path;

import java.util.*;

// 아래 참고
// https://www.youtube.com/watch?v=F-tkqjUiik0&list=PLVsNizTWUw7H9_of5YCB0FmsSc-K44y81&index=30

public class Dijkstra {
    // 그리디 알고리즘 기법 중 하나
    // 한점에서 다른 점으로 최단거리들을 구함

    static class Node {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        int INF = (int) 1e9;
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

        int[] distance;
        int start = 1;

        // 1 min : 0
        // 2 min : 2
        // 3 min : 3
        // 4 min : 1
        // 5 min : 2
        // 6 min : 4

        System.out.println("-- 방법 1");
        distance = solution(edges, n, start);

        // 0 이 시작 지점
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == INF) {
                System.out.println("INFINITY");
            } else {
                System.out.println(i + " : " + distance[i]);
            }
        }

        System.out.println("\n-- 방법 2");
        distance = solution2(edges, n, start);

        // 0 이 시작 지점
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == INF) {
                System.out.println("INFINITY");
            } else {
                System.out.println(i + " : " + distance[i]);
            }
        }
    }

    /*
     * edges : 엣지 정보
     * n : 노드 개수
     * start : 시작점
     * */
    static int[] solution2(int[][] edges, int n, int start) {
        int INF = (int) 1e9;
        
        // 최소 거리 정보 초기화
        int[] distance = new int[n + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0; // 시작 지점은 0

        // 인접 메트릭스로 그래프 표현
        int[][] graph = new int[n + 1][n + 1];
        for (int v = 0; v < graph.length; v++)
            Arrays.fill(graph[v], INF);

        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            int cost = edge[2];
            graph[source][destination] = cost;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(o -> o[1]));

        // int[]{ 노드, 노드까지 가는 최소 비용 }
        pq.offer(new int[]{start, distance[start]}); // 시작점 큐에 추가

        // 'start' 에서 모든 지점의 최단 거리를 구함
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int now = node[0];
            int dist = node[1];

            if (distance[now] < dist)
                continue;

            for (int adj = 1; adj <= n; adj++) {
                // 예외 처리 : 자기자신과 인접 하지 않는 노드 제외
                if (now == adj || graph[now][adj] == INF)
                    continue;

                // 현재까지의 최단거리 비용 + 인접한 노드의 추가 거리 비용
                int cost = distance[now] + graph[now][adj];
                
                // 현재 노드를 거친 인접 노드 거리 비용 vs 인접 노드 distance 테이블의 값
                if (cost < distance[adj]) {
                    distance[adj] = cost;
                    pq.offer(new int[]{adj, cost});
                }
            }
        }

        return distance;
    }


    /*
     * edges : 엣지 정보
     * n : 노드 개수
     * start : 시작점
     * */
    static int[] solution(int[][] edges, int n, int start) {
        int INF = (int) 1e9;
        int[] distance = new int[n + 1];
        Arrays.fill(distance, INF);

        // 리스트로 그래프 표현
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            int cost = edge[2];

            graph.get(source).add(new Node(destination, cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(o -> o.distance));
        pq.offer(new Node(start, 0)); // 시작점 큐에 추가
        distance[start] = 0; // 시작 지점은 0

        // 'start' 에서 모든 지점의 최단 거리를 구함
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.index;
            int dist = node.distance;

            if (distance[now] < dist)
                continue;

            for (Node adj : graph.get(now)) {
                int cost = distance[now] + adj.distance;
                if (cost < distance[adj.index]) {
                    distance[adj.index] = cost;
                    pq.offer(new Node(adj.index, cost));
                }
            }
        }

        return distance;
    }
}
