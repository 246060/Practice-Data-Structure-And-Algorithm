package data_structure.Graph.Tree.Binary_Indexed_Tree;

public class Binary_Indexed_Tree {
    // 출처 : https://m.blog.naver.com/ndb796/221312822103

    static int[] tree;

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};
        tree = new int[a.length + 1];

        for (int i = 0; i < a.length; i++) {
            update(i, a[i]);
        }

        System.out.println(sum(1, 4));
        update(2, -2);

        System.out.println(sum(1, 4));

        update(4, 2);

        System.out.println(sum(1, 4));
        System.out.println(sum(0, 4));
    }

    static void update(int targetIndex, int val) {
        targetIndex++;
        while (targetIndex < tree.length) {
            tree[targetIndex] += val;
            targetIndex += (targetIndex & -targetIndex);
        }
    }

    static int sum(int i) {
        i++;
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= (i & -i);
        }
        return sum;
    }

    static int sum(int l, int r) {
        return sum(r) - sum(l - 1);
    }
}
