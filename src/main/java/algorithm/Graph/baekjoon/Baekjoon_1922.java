package algorithm.Graph.baekjoon;

import java.util.*;

public class Baekjoon_1922 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(o -> o[2]));
        for (int i = 0; i < M; i++)
            pq.offer(new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()});

        int[] parent = makeSet(new int[N + 1]);
        int cost = 0;
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int s = edge[0];
            int d = edge[1];
            int c = edge[2];

            if (findParent(parent, s) == findParent(parent, d)) continue;
            union(parent, s, d);

            cost += c;
        }

        System.out.println(cost);
    }

    static void union(int[] parent, int node1, int node2) {
        node1 = findParent(parent, node1);
        node2 = findParent(parent, node2);

        if (node1 < node2) {
            parent[node2] = node1;
        } else {
            parent[node1] = node2;
        }
    }

    static int findParent(int[] parent, int node) {
        if (parent[node] != node) {
            return parent[node] = findParent(parent, parent[node]);
        } else {
            return node;
        }
    }

    static int[] makeSet(int[] parent) {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        return parent;
    }
}
