package algorithm.Graph.Minimum_Spanning_Tree;

import java.util.*;

public class MinimumSpanningTree {

    public static void main(String[] args) {

        // https://algotree.org/algorithms/minimum_spanning_tree/prims_java/
        // https://bepoz-study-diary.tistory.com/163
        // https://velog.io/@agugu95/Prims-Algorithm%ED%94%84%EB%A6%BC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98

        int N = 6;
        ArrayList<int[]> edges = new ArrayList<>();

        // (source, destination, cost)
        edges.add(new int[]{0, 1, 4});
        edges.add(new int[]{0, 2, 1});
        edges.add(new int[]{0, 3, 5});

        edges.add(new int[]{1, 0, 4});
        edges.add(new int[]{1, 3, 2});
        edges.add(new int[]{1, 4, 3});
        edges.add(new int[]{1, 5, 3});

        edges.add(new int[]{2, 0, 1});
        edges.add(new int[]{2, 3, 2});
        edges.add(new int[]{2, 4, 8});

        edges.add(new int[]{3, 0, 5});
        edges.add(new int[]{3, 1, 2});
        edges.add(new int[]{3, 2, 2});
        edges.add(new int[]{3, 4, 1});

        edges.add(new int[]{4, 1, 3});
        edges.add(new int[]{4, 2, 8});
        edges.add(new int[]{4, 3, 1});
        edges.add(new int[]{4, 5, 4});

        edges.add(new int[]{5, 1, 3});
        edges.add(new int[]{5, 4, 4});

        int minCost = lazyPrims(edges, N);

        System.out.println(minCost == 9);
    }

    private static int lazyPrims(ArrayList<int[]> edges, int n) {

        int mincost = 0;
        ArrayList<int[]> mst = new ArrayList<>();

        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        Queue<Integer> q = new LinkedList<>();
        q.offer(edges.get(0)[0]);

        while (!q.isEmpty()) {
            int cur = q.poll();
            visited[cur] = true;

            for (int[] edge : edges) {
                if (cur != edge[0]) continue;
                if (!visited[edge[1]])
                    pq.offer(edge);
            }

            while (!pq.isEmpty()) {
                int[] edge = pq.poll();

                if (visited[edge[1]])
                    continue;

                visited[edge[1]] = true;
                mincost += edge[2];
                q.offer(edge[1]);
                mst.add(edge);
                break;
            }
        }

        print(mst);
        return mincost;
    }

    static void print(ArrayList<int[]> mst) {
        for (int[] edge : mst) {
            int source = edge[0];
            int destination = edge[1];
            int cost = edge[2];
            System.out.format("%d -> %d : %d", source, destination, cost);
            System.out.println();
        }
    }
}







