package concept_study.data_structure.Sparse_Table;

import java.util.Arrays;

public class SparseTable2 {

    public static void main(String[] args) {

        int a[] = {4, 2, 3, 7, 1, 5, 3, 3, 9, 6, 7, -1, 4};
        int[][] st = build(a);

        for (int[] row : st) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println(query(st, 2, 7));
        System.out.println(query(st, 3, 5));
    }

    private static int[][] build(int[] a) {
        int n = a.length;
        int h = (int) Math.floor(Math.log(n) / Math.log(2));

        int[][] st = new int[h + 1][n];

        for (int i = 0; i < n; i++) {
            st[0][i] = a[i];
        }

        for (int i = 1; i < h + 1; i++) {
            for (int j = 0; j + (1 << i) - 1 < n; j++) {
                int left = st[i - 1][j];
                int right = st[i - 1][j + (1 << (i - 1))];
                st[i][j] = fun(left, right);
            }
        }

        return st;
    }

    private static int fun(int left, int right) {
        return Math.min(left, right);
    }

    private static int query(int[][] st, int L, int R) {
        int p = (int) (Math.log(R - L + 1) / Math.log(2));
        int k = (1 << p);

        return fun(st[p][L], st[p][R - k + 1]);
    }

}
