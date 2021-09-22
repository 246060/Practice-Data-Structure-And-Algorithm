package data_structure.Graph.Tree.Segment_Tree;

public class Segment_tree_Efficient_implementation {
    // https://www.geeksforgeeks.org/segment-tree-efficient-implementation/
    // // https://www.youtube.com/watch?v=Oq2E2yGadnU

    // Time Complexities:
    //      Tree Construction   : O(n)
    //      Query in Range      : O(Log n)
    //      Updating an element : O(Log n)

    //  interval [L,R) with left index(L) included and right (R) excluded.

    static public void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        n = a.length;
        tree = new int[2 * n];

        // build tree
        build(a);

        // print the sum in range(1,2) index-based
        System.out.println(query(1, 3));

        // modify element at 2nd index
        updateTreeNode(2, 1);

        // print the sum in range(1,2) index-based
        System.out.println(query(1, 3));
    }

    // limit for array size
    static int N = 100000;
    static int n; // array size

    // Max size of tree
    static int[] tree;

    // function to build the tree
    static void build(int[] arr) {

        // insert leaf nodes in tree
        for (int i = 0; i < n; i++)
            tree[n + i] = arr[i];

        // build the tree by calculating parents
        for (int i = n - 1; i > 0; --i)
            tree[i] = tree[i << 1] + tree[i << 1 | 1]; // | : Or
    }

    // function to update a tree node
    static void updateTreeNode(int p, int value) {

        // set value at position p
        tree[p + n] = value;
        p = p + n;

        // move upward and update parents
        for (int i = p; i > 1; i >>= 1)
            tree[i >> 1] = tree[i] + tree[i ^ 1]; // ^ : Xor
    }

    // function to get sum on interval [l, r)
    static int query(int l, int r) {
        int res = 0;

        // loop to find the sum in the range
        for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
            if ((l & 1) > 0) res += tree[l++];
            if ((r & 1) > 0) res += tree[--r];
        }

        return res;
    }
}
