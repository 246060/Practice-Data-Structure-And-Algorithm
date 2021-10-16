package concept_study.algorithm.Graph.Articulation_Point;

import java.util.Arrays;

public class 네트웍 {

    static boolean[][] a;
    static boolean[] ap;
    static int[] check;
    static int n, total, cnt, start, child;

    public static void main(String[] args) {
        String[] input = """
                5
                5 1 2 3 4
                0
                6
                2 1 3
                5 4 6 2
                0
                0
                """.split("\n");

        int idx = 0;
        while (true) {
            n = Integer.parseInt(input[idx++]);
            if (n == 0) break;

            a = new boolean[100][100];
            ap = new boolean[100];
            check = new int[100];
            total = cnt = child = 0;

            start = -1;
            for (int i = 0; i < n; i++) {
                int[] vertex = Arrays.stream(input[idx++].split(" "))
                                     .mapToInt(Integer::parseInt)
                                     .toArray();
                int m = vertex[0];
                if (m == 0) break;
                if (start == -1) start = m - 1;

                for (int j = 1; j < vertex.length; j++) {
                    a[m - 1][vertex[j] - 1] = a[vertex[j] - 1][m - 1] = true;
                }
            }

            AP(start);

            if (child > 1) {
                ap[start] = true;
                ++total;
            }

            System.out.println(total);
        }
    }

    static int AP(int s) {
        check[s] = ++cnt;
        int mn = cnt;

        for (int i = 0; i < n; i++) {
            if (a[s][i]) {
                if (check[i] == 0) {
                    if (s == start)
                        ++child;

                    int x = AP(i);
                    mn = Math.min(mn, x);

                    if (x >= check[s] && s != start && !ap[s]) {
                        ap[s] = true;
                        total++;
                    }

                } else if (mn > check[i]) {
                    mn = check[i];
                }
            }
        }
        return mn;
    }
}
