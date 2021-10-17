package concept_study.algorithm.graph.Lowest_Common_Ancestor;

public class LCA_in_Parent_Array_Representation {
    // https://www.geeksforgeeks.org/lowest-common-ancestor-in-parent-array-representation/

    // (1) Make a parent array and store the parent of ith node in it. Parent of root node should be -1.
    // (2) Now, access all the nodes from the desired node ‘m’ till root node and mark them visited.
    // (3) Lastly, access all the nodes from the desired node ‘n’ till first visited node comes.
    // (4) This node is the lowest common ancestor

    // * Time Complexity
    // The time complexity is O(log n) as it requires O(log n) time in searching.

    public static void main(String[] args) {

        // Maximum capacity of binary tree
        int[] parent = new int[MAX];

        // Root marked
        parent[20] = -1;
        insertAdj(parent, 8, 20);
        insertAdj(parent, 22, 20);
        insertAdj(parent, 4, 8);
        insertAdj(parent, 12, 8);
        insertAdj(parent, 10, 12);
        insertAdj(parent, 14, 12);

        System.out.println(findLCA(10, 14, parent));
    }

    // Maximum value in a node
    static int MAX = 1000;

    // Insert function for Binary tree
    static void insertAdj(int[] parents, int child, int parent) {
        // parent of vertex i is j
        parents[child] = parent;
    }

    // Function to find the Lowest common ancestor
    static int findLCA(int n1, int n2, int[] parent) {

        // Create a visited vector and mark all nodes as not visited.
        boolean[] visited = new boolean[MAX];
        visited[n1] = true;

        // Moving from n1 node till root and mark every accessed node as visited
        while (parent[n1] != -1) {
            visited[n1] = true;

            // Move to the parent of node n1
            n1 = parent[n1];
        }

        visited[n1] = true;

        // For second node finding the first node common
        while (!visited[n2])
            n2 = parent[n2];

        return n2;
    }


}
