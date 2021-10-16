package concept_study.algorithm.Graph.Minimum_Spanning_Tree;

import java.util.ArrayList;
import java.util.Arrays;

public class DisjointSetUnion {

    public static void main(String[] args) {

        DisjointSetUnion disjointSetUnion = new DisjointSetUnion();

        int N = 7;
        ArrayList<int[]> edges = new ArrayList<>();

        // (source, destination, cost)
        edges.add(new int[]{0, 1, 4});
        edges.add(new int[]{1, 2, 1});
        edges.add(new int[]{2, 3, 5});

        edges.add(new int[]{4, 5, 4});
        edges.add(new int[]{5, 6, 2});
        edges.add(new int[]{4, 6, 3});

        int[] parent = disjointSetUnion.makeSet(new int[N]);

        for (int[] edge : edges) {
            disjointSetUnion.union(parent, edge[0], edge[1]);
        }

        // [0, 0, 0, 0, 4, 4, 4]
        System.out.println(Arrays.toString(parent));
    }

    public int find(int[] parent, int node) {
        if (parent[node] != node) {
            // path compression
            return parent[node] = find(parent, parent[node]);
        } else {
            return node;
        }
    }

    public void union(int[] parent, int node1, int node2) {
        node1 = find(parent, node1);
        node2 = find(parent, node2);

        if (node1 < node2) {
            parent[node2] = node1;
        } else {
            parent[node1] = node2;
        }
    }

    public int[] makeSet(int[] parent) {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        return parent;
    }
}
