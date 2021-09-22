package data_structure.Graph.Tree.Segment_Tree;

public class SegmentTree_Min {

    static int[] a = {1, 9, 3, 8, 4, 5, 5, 9, 10, 3, 4, 5};
    static int[] tree;

    public static void main(String[] args) {

        int pos = 2;
        tree = new int[a.length * 4];
        build();

        System.out.println("첫 부터 끝까지 중 min : " + query(0, a.length - 1));
        System.out.println("10 부터 11까지 중 min : " + query(10, 11));
        System.out.println("8 부터 9까지 중 min : " + query(8, 9));
        System.out.println("0 부터 4까지 중 min : " + query(0, 4));
        System.out.println("2 부터 4까지 중 min : " + query(2, 4));

        update(2, -1);

        System.out.println("첫 부터 끝까지 중 min : " + query(0, a.length - 1));
        System.out.println("10 부터 11까지 중 min : " + query(10, 11));
        System.out.println("8 부터 9까지 중 min : " + query(8, 9));
        System.out.println("0 부터 4까지 중 min : " + query(0, 4));
        System.out.println("2 부터 4까지 중 min : " + query(2, 4));
    }

    private static int query(int left, int right) {
        return query(0, a.length - 1, 1, left, right);
    }

    private static int query(int start, int end, int node, int left, int right) {

        if (left > end || right < start) {
            return Integer.MAX_VALUE;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return Math.min(
                query(start, mid, node * 2, left, right),
                query(mid + 1, end, node * 2 + 1, left, right)
        );
    }

    private static void build() {
        build(0, a.length - 1, 1);
    }

    private static int build(int start, int end, int node) {
        if (start == end) {
            return tree[node] = a[start];
        }

        int mid = (start + end) / 2;

        return tree[node] = Math.min(
                build(start, mid, node * 2),
                build(mid + 1, end, node * 2 + 1)
        );
    }

    private static void update(int index, int dif) {
        update(0, a.length - 1, 1, index, dif);
    }

    private static void update(int start, int end, int node, int index, int dif) {

        if (index < start || end < index) {
            return;
        }

        tree[node] = Math.min(tree[node], dif);
        if (start == end) return;

        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, dif);
        update(mid + 1, end, node * 2 + 1, index, dif);
    }
}
