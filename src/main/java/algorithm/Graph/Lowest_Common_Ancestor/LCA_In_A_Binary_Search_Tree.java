package algorithm.Graph.Lowest_Common_Ancestor;

public class LCA_In_A_Binary_Search_Tree {
    // https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/

    // You may like to see below articles as well:
    // * Lowest Common Ancestor in a Binary Tree
    // - https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/

    // * LCA using Parent Pointer
    // - https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-tree-set-2-using-parent-pointer/

    // * Find LCA in Binary Tree using RMQ
    // - https://www.geeksforgeeks.org/find-lca-in-binary-tree-using-rmq/

    public static void main(String[] args) {

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        System.out.println("lca_recursive-----------------------------------------------");
        int n1 = 10, n2 = 14;
        Node t = lca_recursive(root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 14;
        n2 = 8;
        t = lca_recursive(root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 10;
        n2 = 22;
        t = lca_recursive(root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        //-------------------------------------------------------------------
        System.out.println("\nlca_iterative-----------------------------------------------");

        n1 = 10;
        n2 = 14;
        t = lca_iterative(root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 14;
        n2 = 8;
        t = lca_iterative(root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 10;
        n2 = 22;
        t = lca_iterative(root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node lca_recursive(Node node, int n1, int n2) {

        // * Time Complexity: O(h).
        // The time Complexity of this solution is O(h),
        // where h is the height of the tree.
        //
        // * Space Complexity: O(1).
        // If recursive stack space is ignored,
        // the space complexity of this solution is constant.

        if (node == null)
            return null;

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.data > n1 && node.data > n2)
            return lca_recursive(node.left, n1, n2);

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.data < n1 && node.data < n2)
            return lca_recursive(node.right, n1, n2);

        return node;
    }

    /*
     * Iterative Implementation: The above solution uses recursion.
     * The recursive solution requires extra space in the form of the function call stack.
     * So an iterative solution can be implemented which does not occupy space
     * in the form of the function call stack.
     * */
    static Node lca_iterative(Node root, int n1, int n2) {
        /*
         * Function to find LCA of n1 and n2.
         * The function assumes that both n1 and n2 are present in BST
         * */

        // # Complexity Analysis:
        //
        // * Time Complexity: O(h).
        // The Time Complexity of this solution is O(h),
        // where h is the height of the tree.
        //l
        // * Space Complexity: O(1).
        // The space complexity of this solution is constant.

        while (root != null) {

            if (root.data > n1 && root.data > n2) {
                // If both n1 and n2 are smaller than root, then LCA lies in left
                root = root.left;

            } else if (root.data < n1 && root.data < n2) {
                // If both n1 and n2 are greater than root, then LCA lies in right
                root = root.right;

            } else {
                break;
            }
        }

        return root;
    }

}