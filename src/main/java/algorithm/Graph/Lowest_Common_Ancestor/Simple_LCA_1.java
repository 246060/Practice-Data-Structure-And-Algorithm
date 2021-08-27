package algorithm.Graph.Lowest_Common_Ancestor;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11437
public class Simple_LCA_1 {
/*
N(2 ≤ N ≤ 50,000)
트리의 각 정점은 1번부터 N번까지 번호
루트는 1번

두 노드의 쌍 M(1 ≤ M ≤ 10,000)개

첫째 줄에 노드의 개수 N이 주어지고,
다음 N-1개 줄에는 트리 상에서 연결된 두 정점이 주어진다.

그 다음 줄에는 가장 가까운 공통 조상을 알고싶은 쌍의 개수 M이 주어지고,
다음 M개 줄에는 정점 쌍이 주어진다.
# input
15
1 2
1 3
2 4
3 7
6 2
3 8
4 9
2 5
5 11
7 13
10 4
11 15
12 5
14 7
6
6 11
10 9
2 6
7 6
8 13
8 15

# output
2
4
2
1
3
1
    * */

    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int N;
    static int[] parent;
    static int[] level;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        parent = new int[N + 1];
        level = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }

        int M = sc.nextInt();
        int[][] questions = new int[M][2];
        for (int i = 0; i < M; i++) {
            questions[i][0] = sc.nextInt();
            questions[i][1] = sc.nextInt();
        }

        build(1, 0);

        for (int[] question : questions) {
            System.out.println(lca(question[0], question[1]));
        }
    }

    static void build(int node, int pNode) {
        parent[node] = pNode;
        level[node] = level[pNode] + 1;

        for (Integer child : adj.get(node)) {
            if (child == pNode) continue;
            build(child, node);
        }
    }

    static int lca(int a, int b) {

        if (level[a] < level[b]) {
            int t = b;
            b = a;
            a = t;
        }

        while (level[a] != level[b]) {
            a = parent[a];
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

}
