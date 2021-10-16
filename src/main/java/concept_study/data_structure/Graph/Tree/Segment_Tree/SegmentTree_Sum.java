package concept_study.data_structure.Graph.Tree.Segment_Tree;

public class SegmentTree_Sum {

    static int[] a = {1, 9, 3, 8, 4, 5, 5, 9, 10, 3, 4, 5};
    static int[] tree;

    public static void main(String[] args) {
        tree = new int[a.length * 4];

        build(0, a.length - 1, 1);
        System.out.println("0부터 12까지의 구간 합 : " + query(0, 12));
        System.out.println("3부터 8까지의 구간 합 : " + query(3, 8));

        update(5, -5);

        System.out.println("0부터 12까지의 구간 합 : " + query(0, 12));
        System.out.println("3부터 8까지의 구간 합 : " + query(3, 8));
    }

    static int build(int start, int end, int node) {
        if (start == end)
            return tree[node] = a[start];

        int mid = (start + end) / 2;
        return tree[node]
                = build(start, mid, node * 2)
                + build(mid + 1, end, node * 2 + 1);
    }

    static int query(int left, int right) {
        return query(0, a.length - 1, 1, left, right);
    }

    static int query(int start, int end, int node, int left, int right) {

        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && end <= right)
            return tree[node];

        int mid = (start + end) / 2;
        return query(start, mid, node * 2, left, right)
                + query(mid + 1, end, node * 2 + 1, left, right);
    }

    static void update(int index, int dif) {
        update(0, a.length - 1, 1, index, dif);
    }

    static void update(int start, int end, int node, int index, int dif) {

        if (index < start || index > end) {
            return;
        }

        tree[node] += dif;
        if (start == end) return;

        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, dif);
        update(mid + 1, end, node * 2 + 1, index, dif);
    }


}
