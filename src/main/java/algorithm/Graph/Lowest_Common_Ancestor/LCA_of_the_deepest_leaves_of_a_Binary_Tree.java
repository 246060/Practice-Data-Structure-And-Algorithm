package algorithm.Graph.Lowest_Common_Ancestor;

import java.sql.Time;

public class LCA_of_the_deepest_leaves_of_a_Binary_Tree {
    // https://www.geeksforgeeks.org/lowest-common-ancestor-of-the-deepest-leaves-of-a-binary-tree/

    // Time Complexity: O(N)
    // Auxiliary Space: O(1)

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(9);

        System.out.println(lcaOfDeepestLeaves(root).data);
    }

    public static int findDepth(Node root) {
        if (root == null)
            return 0;

        return 1 + Math.max(findDepth(root.left), findDepth(root.right));
    }

    static Node DFS(Node root, int curr, int depth) {

        if (root == null)
            return null;

        if (curr == depth)
            return root;

        Node left = DFS(root.left, curr + 1, depth);
        Node right = DFS(root.right, curr + 1, depth);

        if (left != null && right != null)
            return root;

        return (left != null) ? left : right;
    }

    static Node lcaOfDeepestLeaves(Node root) {

        if (root == null)
            return null;

        // Stores the deepest depth of the binary tree
        int depth = findDepth(root) - 1;

        // Return the LCA of the nodes at level depth
        return DFS(root, 0, depth);
    }

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }
}
