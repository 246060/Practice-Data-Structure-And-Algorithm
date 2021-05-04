package algorithm.Graph.Minimum_Spanning_Tree;

public class DisjointSetUnion {

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
