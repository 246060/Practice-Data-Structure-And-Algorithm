package concept_study.algorithm.graph.Topological_Sorting;

import java.util.Scanner;

public class TS {

    /*
     * 다르게 풀어보자!
     * */

    static int[][] w = new int[100][100];
    static int[] sum = new int[100];

    public static void main(String[] args) {
/* input
6 7
1 2
1 3
3 4
2 4
1 5
3 5
4 6
*/

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            // a -> b 연결 정보
            w[a - 1][b - 1] = 1;

            // in degree
            sum[b - 1]++;
        }

        ts(n);
    }

    static void ts(int n) {

        for (int i = 0; i < n; i++) {

            int j;
            for (j = 0; j < n; j++)
                if (sum[j] == 0) break;

            sum[j] = -1;
            System.out.print(j + 1 + " ");

            for (int k = 0; k < n; k++)
                if (w[j][k] == 1)
                    sum[k]--;
        }
    }
}
