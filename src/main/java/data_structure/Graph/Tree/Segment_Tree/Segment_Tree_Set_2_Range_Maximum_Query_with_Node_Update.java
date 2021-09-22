package data_structure.Graph.Tree.Segment_Tree;

public class Segment_Tree_Set_2_Range_Maximum_Query_with_Node_Update {
    // https://www.geeksforgeeks.org/segment-tree-set-2-range-maximum-query-node-update/

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int n = arr.length;

        // Build segment tree from given array
        int[] st = constructST(arr, n);

        // Print max of values in array from index 1 to 3
        System.out.println("Max of values in given range = " + getMax(st, n, 1, 3));

        // Update: set arr[1] = 8 and update corresponding segment tree nodes.
        updateValue(arr, st, 0, n - 1, 1, 8, 0);

        // Find max after the value is updated
        System.out.println("Updated max of values in given range = " + getMax(st, n, 1, 3));
    }

    // A utility function to get the middle index of given range.
    static int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    /*
     * A recursive function to get the sum of values in given range of the array.
     * The following are parameters for this function.
     *
     * st -> Pointer to segment tree
     * node -> Index of current node in the segment tree.
     * ss & se -> Starting and ending indexes of the segment represented by current node, i.e., st[node]
     * l & r -> Starting and ending indexes of range query
     */
    static int MaxUtil(int[] st, int ss, int se, int l, int r, int node) {

        // If segment of this node is completely part of given range, then return the max of segment
        if (l <= ss && r >= se)
            return st[node];

        // If segment of this node does not belong to given range
        if (se < l || ss > r)
            return -1;

        // If segment of this node is partially the part of given range
        int mid = getMid(ss, se);

        int leftMax = MaxUtil(st, ss, mid, l, r, 2 * node + 1);
        int rightMax = MaxUtil(st, mid + 1, se, l, r, 2 * node + 2);

        return Math.max(leftMax, rightMax);
    }

    /*
     * A recursive function to update the nodes which have the given index in their range.
     * The following are parameters st, ss and se are same as defined above index -> index of the element to be updated.
     */
    static void updateValue(int[] arr, int[] st, int ss, int se, int index, int value, int node) {

        if (index < ss || index > se) {
            System.out.println("Invalid Input");
            return;
        }

        if (ss == se) { // arrived at leaf node
            // update value in array and in segment tree
            arr[index] = value;
            st[node] = value;

        } else {
            int mid = getMid(ss, se);

            if (ss <= index && index <= mid)
                updateValue(arr, st, ss, mid, index, value, 2 * node + 1);
            else
                updateValue(arr, st, mid + 1, se, index, value, 2 * node + 2);

            st[node] = Math.max(st[2 * node + 1], st[2 * node + 2]);
        }

        return;
    }

    // Return max of elements in range from index l (query start) to r (query end).
    static int getMax(int[] st, int n, int l, int r) {

        // Check for erroneous input values
        if (l < 0 || r > n - 1 || l > r) {
            System.out.printf("Invalid Input\n");
            return -1;
        }

        return MaxUtil(st, 0, n - 1, l, r, 0);
    }

    // A recursive function that constructs Segment Tree for array[ss..se].
    // si is index of current node in segment tree st
    static int constructSTUtil(int[] arr, int ss, int se, int[] st, int si) {

        // If there is one element in array,
        // store it in current node of segment tree and return
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }

        // If there are more than one elements,
        // then recur for left and right subtrees
        // and store the max of values in this node
        int mid = getMid(ss, se);

        int leftMax = constructSTUtil(arr, ss, mid, st, si * 2 + 1);
        int rightMax = constructSTUtil(arr, mid + 1, se, st, si * 2 + 2);

        return st[si] = Math.max(leftMax, rightMax);
    }

    // Function to construct segment tree from given array.
    static int[] constructST(int[] arr, int n) {

        // Height of segment tree
        int x = (int) Math.ceil(Math.log(n) / Math.log(2));

        // Maximum size of segment tree
        int max_size = 2 * (1 << x) - 1;
        int[] st = new int[max_size];

        constructSTUtil(arr, 0, n - 1, st, 0);
        return st;
    }
}
