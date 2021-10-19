package concept_study.algorithm.graph.Traversal;

import java.util.ArrayList;

public class Euler_Tour_of_Tree {
    // https://www.geeksforgeeks.org/euler-tour-tree/

    // Auxiliary Space :O(N)
    // Time Complexity: O(N)

    public static void main(String[] args) {
        int N = 4;

        for (int i = 0; i <= N; i++)
            adj.add(new ArrayList<>());

        add_edge(1, 2);
        add_edge(2, 3);
        add_edge(2, 4);

        // Consider 1 as root and print Euler tour
        // 1 2 3 2 4 2 1
        printEulerTour(1, N);
    }

    static final int MAX = 1001;
    static int indx = 0;

    // Adjacency list representation of tree
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    // Visited array to keep track visited nodes on tour
    static int[] vis = new int[MAX];

    // Array to store Euler Tour
    static int[] Euler = new int[2 * MAX];

    // Function to add edges to tree
    static void add_edge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // Function to store Euler Tour of tree
    static void eulerTree(int u) {
        vis[u] = 1;
        Euler[indx++] = u;

        for (int it : adj.get(u)) {
            if (vis[it] == 0) {
                eulerTree(it);
                Euler[indx++] = u;
            }
        }
    }

    // Function to print Euler Tour of tree
    static void printEulerTour(int root, int N) {
        eulerTree(root);

        for (int i = 0; i < (2 * N - 1); i++)
            System.out.print(Euler[i] + " ");
    }


}
