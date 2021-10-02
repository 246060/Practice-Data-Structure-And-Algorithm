package algorithm.Graph.Articulation_Point;

import java.util.Scanner;

public class 단절점 {

    static boolean[][] graph;
    static boolean[] ap;
    static int[] check;
    static int total, cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        graph = new boolean[V + 1][V + 1];
        check = new int[V + 1];
        ap = new boolean[V + 1];

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = graph[b][a] = true;
        }

        for (int i = 1; i <= V; i++) {
            if (check[i] == 0) {
                cnt = 0;
                AP(i, true);
            }
        }

        System.out.println(total);
        for (int i = 1; i < ap.length; i++) {
            if (ap[i])
                System.out.print(i + " ");
        }
    }

    static int AP(int s, boolean isRoot) {
        check[s] = ++cnt;
        int mn = cnt;
        int child = 0;

        for (int i = 1; i < graph[s].length; i++) {
            if (!graph[s][i]) continue;

            if (check[i] == 0) {
                child++;

                int x = AP(i, false);
                if (mn > x) mn = x;

                if (x >= check[s] && !isRoot && !ap[s]) {
                    ap[s] = true;
                    total++;
                }
            } else if (mn > check[i]) {
                mn = check[i];
            }
        }

        if (isRoot && child > 1) {
            ap[s] = true;
            total++;
        }

        return mn;
    }
}
