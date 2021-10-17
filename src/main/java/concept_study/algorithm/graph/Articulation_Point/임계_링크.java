package concept_study.algorithm.graph.Articulation_Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 임계_링크 {
    // 단절선 문제

    public static void main(String[] args) {
/* inpuit
8
0 (1) 1
1 (3) 2 0 3
2 (2) 1 3
3 (3) 1 2 4
4 (1) 3
7 (1) 6
6 (1) 7
5 (0)

0
 */
        String message = " critical links";
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            int N = Integer.parseInt(input);
            if (N == 0) {
                System.out.println("0" + message);
                break;
            }

            graph = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < N; i++) {
                String[] split = sc.nextLine().split(" ");
                int from = Integer.parseInt(split[0]);
                int M = Integer.parseInt(split[1].replace("(", "").replace(")", ""));
                for (int j = 0; j < M; j++) {
                    graph[from].add(Integer.parseInt(split[2 + j]));
                }
            }

            prev = new int[N];
            low = new int[N];
            parent = new int[N];
            Arrays.fill(parent, -1);
            time = total = 0;
            bridges = new ArrayList<>();

            for (int i = 0; i < N; i++)
                if (prev[i] == 0)
                    bridge(i);

            bridges.sort(Comparator.comparingInt(v -> v[0]));

            System.out.println(total + message);

            for (int[] bridge : bridges)
                System.out.println(bridge[0] + " - " + bridge[1]);

            sc.nextLine();
        }

    }

    static ArrayList<Integer>[] graph;
    static int[] prev, low, parent;
    static int time, total;
    static ArrayList<int[]> bridges;

    // prev, low 를 이용하여 좀 다르게 풀어봄.
    static void bridge(int s) {
        prev[s] = low[s] = ++time;

        for (int adj : graph[s]) {
            if (adj == parent[s])
                continue;

            if (prev[adj] == 0) {
                parent[adj] = s;

                bridge(adj);
                low[s] = Math.min(low[s], low[adj]);

                if (low[adj] > prev[s]) {
                    bridges.add(new int[]{Math.min(s, adj), Math.max(s, adj)});
                    total++;
                }
            } else {
                low[s] = Math.min(low[s], prev[adj]);
            }
        }

    }
}
