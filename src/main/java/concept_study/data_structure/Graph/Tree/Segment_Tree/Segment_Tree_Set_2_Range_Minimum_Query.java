package concept_study.data_structure.Graph.Tree.Segment_Tree;

public class Segment_Tree_Set_2_Range_Minimum_Query {
    // https://www.geeksforgeeks.org/segment-tree-set-1-range-minimum-query/

    public static void main(String args[]) {

        int arr[] = {1, 3, 2, 7, 9, 11};
        int n = arr.length;

        // Build segment tree from given array
        constructST(arr, n);

        int qs = 1;  // Starting index of query range
        int qe = 5;  // Ending index of query range

        // Print minimum value in arr[qs..qe]
        System.out.format("Minimum of values in range [%d, %d] is = %d", qs, qe, RMQ(n, qs, qe));
    }

    // array to store segment tree
    static int st[];

    static int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    /*
        A recursive function to get the minimum value in a given range of array indexes.
        The following are parameters for this function.

        st       --> Pointer to segment tree
        index    --> Index of current node in the segment tree. Initially 0 is passed as root is always at index 0
        ss & se  --> Starting and ending indexes of the segment represented by current node, i.e., st[index]
        qs & qe  --> Starting and ending indexes of query range
     */
    static int RMQUtil(int ss, int se, int qs, int qe, int index) {

        // If segment of this node is a part of given range,
        // then return the min of the segment
        if (qs <= ss && qe >= se)
            return st[index];

        // If segment of this node is outside the given range
        if (se < qs || ss > qe)
            return Integer.MAX_VALUE;

        // If a part of this segment overlaps with the given range
        int mid = getMid(ss, se);

        int leftMin = RMQUtil(ss, mid, qs, qe, 2 * index + 1);
        int rightMin = RMQUtil(mid + 1, se, qs, qe, 2 * index + 2);

        return Math.min(leftMin, rightMin);
    }

    // Return minimum of elements in range from index qs (query start) to qe (query end).
    static int RMQ(int n, int qs, int qe) {

        if (qs < 0 || qe > n - 1 || qs > qe) {
            System.out.println("Invalid Input");
            return -1;
        }

        return RMQUtil(0, n - 1, qs, qe, 0);
    }

    // A recursive function that constructs Segment Tree for
    // array[ss..se]. si is index of current node in segment tree st
    static int constructSTUtil(int arr[], int ss, int se, int si) {

        // If there is one element in array, store it in current node of segment tree and return
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }

        // If there are more than one elements,
        // then recur for left and right subtrees
        // and store the minimum of two values in this node
        int mid = getMid(ss, se);

        int leftMin = constructSTUtil(arr, ss, mid, si * 2 + 1);
        int rightMin = constructSTUtil(arr, mid + 1, se, si * 2 + 2);

        return st[si] = Math.min(leftMin, rightMin);
    }

    static void constructST(int arr[], int n) {

        //Height of segment tree
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

        //Maximum size of segment tree
        int max_size = 2 * (1 << x) - 1;
        st = new int[max_size];

        // Fill the allocated memory st
        constructSTUtil(arr, 0, n - 1, 0);
    }
}
