package algorithm.Graph.Segment_Tree;


public class SegmentTreeRMQ {
    // Range Minimum Query(RMQ)
    // 세그먼트 트리 기본 유형
    // https://www.geeksforgeeks.org/segment-tree-set-1-range-minimum-query/

    public static void main(String[] args) {

        int arr[] = {1, 3, 2, 7, 9, 11};
        int n = arr.length;

        // Build segment tree from given array
        SegmentTreeRMQ tree = new SegmentTreeRMQ();
        tree.constructST(arr, n);

        int qStart = 1;  // Starting index of query range
        int qEnd = 5;  // Ending index of query range

        // Print minimum value in arr[qs..qe]
        System.out.format("Minimum of values in range [%d, %d] is = %d\n", qStart, qEnd, tree.RMQ(n, qStart, qEnd));
    }

    int st[]; //array to store segment tree

    int RMQ(int n, int qStart, int qEnd) {

        // Check for erroneous input values
        if (qStart < 0 || qEnd > n - 1 || qStart > qEnd) {
            System.out.println("Invalid Input");
            return -1;
        }

        return RMQUtil(0, n - 1, qStart, qEnd, 0);
    }

    /*
     * A recursive function to get the minimum value in a given range of array indexes.
     * The following are parameters for this function.
     *
     * st    --> Pointer to segment tree
     * index --> Index of current node in the segment tree. Initially 0 is passed as root is always at index 0
     * ss & se  --> Starting and ending indexes of the segment represented by current node, i.e., st[index]
     * qs & qe  --> Starting and ending indexes of query range
     * */
    private int RMQUtil(int start, int end, int qStart, int qEnd, int index) {

        // If segment of this node is a part of given range, then return the min of the segment
        if (qStart <= start && qEnd >= end)
            return st[index];

        // If segment of this node is outside the given range
        if (end < qStart || start > qEnd)
            return Integer.MAX_VALUE;

        // If a part of this segment overlaps with the given range
        int mid = getMidIndex(start, end);
        int left = RMQUtil(start, mid, qStart, qEnd, 2 * index + 1);
        int right = RMQUtil(mid + 1, end, qStart, qEnd, 2 * index + 2);

        return Math.min(left, right);
    }


    /*
     * Function to construct segment tree from given array. This function
     * allocates memory for segment tree and calls constructSTUtil() to
     * fill the allocated memory
     * */
    private void constructST(int[] arr, int n) {

        //Height of segment tree
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

        //Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        st = new int[max_size]; // allocate memory

        // Fill the allocated memory st
        constructSTUtil(arr, 0, n - 1, 0);
    }

    /*
     * A recursive function that constructs Segment Tree for
     * array[ss..se]. si is index of current node in segment tree st
     * */
    int constructSTUtil(int[] arr, int start, int end, int index) {

        // If there is one element in array, store it in current node of segment tree and return
        if (start == end) {
            st[index] = arr[start];
            return arr[start];
        }

        // If there are more than one elements, then recur for left and
        // right subtrees and store the minimum of two values in this node
        int mid = getMidIndex(start, end);

        int left = constructSTUtil(arr, start, mid, index * 2 + 1);
        int right = constructSTUtil(arr, mid + 1, end, index * 2 + 2);

        return st[index] = Math.min(left, right);
    }

    // A utility function to get the middle index from corner indexes.
    private int getMidIndex(int start, int end) {
        return start + (end - start) / 2;
    }
}
