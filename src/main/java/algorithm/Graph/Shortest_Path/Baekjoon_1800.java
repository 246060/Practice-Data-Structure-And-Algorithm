package algorithm.Graph.Shortest_Path;

import java.util.*;

public class Baekjoon_1800 {
// 파라메트릭 서치 + 다익스트라

    static class Node {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();
        int K = sc.nextInt();

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < P; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(source).add(new Node(destination, cost));
            graph.get(destination).add(new Node(source, cost));

            max = Math.max(max, cost);
        }

        int front = 0, rear = max;
        int ans = -1;

        while (front <= rear) {
            int mid = (front + rear) / 2;
            if (dickstra(N, graph, K, mid)) {
                ans = mid;
                rear = mid - 1;
            } else {
                front = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static boolean dickstra(int N, ArrayList<ArrayList<Node>> graph, int K, int x) {
        final int INF = (int) 1e9;
        int[] distances = new int[N + 1];
        Arrays.fill(distances, INF);

        int start = 1;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(o -> o.distance));
        pq.offer(new Node(start, 0));
        distances[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.index;
            int dis = node.distance;

            if (distances[now] < dis) {
                continue;
            }

            for (Node adj : graph.get(now)) {
                // cost를 누적 합해주는 개념보다는 조건에 해당하는 edge의 수를 세어나가는 것.
                // 인접 연결 edge 중 검색 중인 x값보다 큰 경우 +1;
                int cost = dis + (adj.distance > x ? 1 : 0);
                // x는 이 함수의 밖에서 이진탐색의 mid 값(최솟값 후보)

                if (cost < distances[adj.index]) {
                    distances[adj.index] = cost;
                    pq.offer(new Node(adj.index, cost));
                }
            }
        }

        // K : 무료 설치 수 
        // distances[N] : 최소값 후보 보다 큰 edge의 수
        return distances[N] <= K;
    }
}
