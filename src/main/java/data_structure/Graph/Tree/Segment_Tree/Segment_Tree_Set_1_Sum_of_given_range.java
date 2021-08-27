package data_structure.Graph.Tree.Segment_Tree;

public class Segment_Tree_Set_1_Sum_of_given_range {
    // https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
    // https://www.geeksforgeeks.org/segment-tree-efficient-implementation/

    public static void main(String args[]) {

        int arr[] = {1, 3, 5, 7, 9, 11};
        int n = arr.length;

        // x : Height of segment tree
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

        // Maximum size of segment tree
        int max_size = 2 * (1 << x) - 1;
        st = new int[max_size];

        // Build segment tree from given array
        constructSTUtil(arr, 0, n - 1, 0);

        System.out.println("Sum of values in given range = " + getSum(n, 1, 3));

        // Update: set arr[1] = 10 and update corresponding segment tree nodes
        updateValue(arr, n, 1, 10);

        System.out.println("Updated sum of values in given range = " + getSum(n, 1, 3));
    }

    // The array that stores segment tree nodes
    static int st[];

    static int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    /*
        A recursive function to get the sum of values in given range of the array.
        The following are parameters for this function.

        st       --> Pointer to segment tree
        si       --> Index of current node in the segment tree. Initially 0 is passed as root is always at index 0
        ss & se  --> Starting and ending indexes of the segment represented by current node, i.e., st[si]
        qs & qe  --> Starting and ending indexes of query range
      */
    static int getSumUtil(int ss, int se, int qs, int qe, int si) {

        // Case 1 : If segment of this node is a part of given range, then return the sum of the segment
        if (qs <= ss && se <= qe)
            return st[si];

        // Case 2 : If segment of this node is outside the given range
        if (se < qs || ss > qe)
            return 0;

        // Case 3 : If a part of this segment overlaps with the given range
        int mid = getMid(ss, se);

        int left = getSumUtil(ss, mid, qs, qe, 2 * si + 1);
        int right = getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);

        return left + right;
    }

    /*
        A recursive function to update the nodes which have the given index in their range.
        The following are parameters st, si, ss and se are same as getSumUtil()

        i    --> index of the element to be updated. This index is in input array.
        diff --> Value to be added to all nodes which have i in range
    */
    static void updateValueUtil(int ss, int se, int i, int diff, int si) {

        // Base Case: If the input index lies outside the range of this segment
        if (i < ss || se < i)
            return;

        // If the input index is in range of this node, then update the value of the node and its children
        st[si] = st[si] + diff;

        if (se != ss) {
            int mid = getMid(ss, se);

            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
    }

    // The function to update a value in input array and segment tree.
    // It uses updateValueUtil() to update the value in segment tree
    static void updateValue(int[] arr, int n, int i, int new_val) {

        // Check for erroneous input index
        if (i < 0 || n - 1 < i) {
            System.out.println("Invalid Input");
            return;
        }

        // Get the difference between new value and old value
        int diff = new_val - arr[i];

        // Update the value in array
        arr[i] = new_val;

        // Update the values of nodes in segment tree
        updateValueUtil(0, n - 1, i, diff, 0);
    }

    // Return sum of elements in range from index qs (quey start) to qe (query end).
    // It mainly uses getSumUtil()
    static int getSum(int n, int qs, int qe) {

        // Check for erroneous input values
        if (qs < 0 || qe > n - 1 || qs > qe) {
            System.out.println("Invalid Input");
            return -1;
        }

        return getSumUtil(0, n - 1, qs, qe, 0);
    }

    // A recursive function that constructs Segment Tree for array[ss..se].
    // si is index of current node in segment tree st
    static int constructSTUtil(int[] arr, int ss, int se, int si) {

        // If there is one element in array, store it in current node of segment tree and return
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }

        // If there are more than one elements,
        // then recur for left and right subtrees and store the sum of values in this node
        int mid = getMid(ss, se);
        st[si] = constructSTUtil(arr, ss, mid, si * 2 + 1) + constructSTUtil(arr, mid + 1, se, si * 2 + 2);

        return st[si];
    }
}