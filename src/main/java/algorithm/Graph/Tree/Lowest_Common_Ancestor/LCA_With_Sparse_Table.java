package algorithm.Graph.Tree.Lowest_Common_Ancestor;

import java.util.ArrayList;

public class LCA_With_Sparse_Table {

    static ArrayList<Integer>[] tree;
    static int[][] parent;
    static int[] deep;
    static boolean[] visit;
    static int N;

    public static void main(String[] args) throws Exception {

        N = 15;
        int[][] edges = {
                {1, 2}, {1, 3}, {2, 4}, {3, 7}, {6, 2}, {3, 8}, {4, 9},
                {2, 5}, {5, 11}, {7, 13}, {10, 4}, {11, 15}, {12, 5}, {14, 7},
        };

        int[][] queries = {{6, 11}, {10, 9}, {2, 6}, {7, 6}, {8, 13}, {8, 15}};

        parent = new int[N + 1][21];
        deep = new int[N + 1];
        visit = new boolean[N + 1];
        tree = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++)
            tree[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            tree[edges[i][0]].add(edges[i][1]);
            tree[edges[i][1]].add(edges[i][0]);
        }

        dfs(1, 0);
        dp();

        int M = 6;
        for (int i = 0; i < M; i++)
            System.out.println(LCA(queries[i][0], queries[i][1]));
    }

    static void dfs(int current, int depth) {
        visit[current] = true;
        deep[current] = depth;

        for (int adj : tree[current]) {
            if (visit[adj])
                continue;

            parent[adj][0] = current;
            dfs(adj, depth + 1);
        }
    }

    static void dp() {
        for (int p = 1; p < 21; p++)
            for (int cur = 1; cur < N + 1; cur++)
                parent[cur][p] = parent[parent[cur][p - 1]][p - 1];
    }

    static int LCA(int v1, int v2) {

        if (deep[v1] > deep[v2]) {
            int tmp = v1;
            v1 = v2;
            v2 = tmp;
        }

        for (int i = 20; i >= 0; i--)
            if (deep[v2] - deep[v1] >= (1 << i))
                v2 = parent[v2][i]; // 위로 2^i번 jump

        if (v1 == v2)
            return v1;

        for (int i = 20; i >= 0; i--) {
            if (parent[v1][i] == parent[v2][i])
                continue;

            v1 = parent[v1][i]; // 2^i
            v2 = parent[v2][i];
        }

        return parent[v1][0];
    }
}
