package algorithm.Graph.Articulation_Point.baekjoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class 단절점과_단절선 {

    static ArrayList<Integer>[] graph;
    static int[] check1, check2;
    static int time1, time2;

    static boolean[] ap;

    static HashMap<Integer, int[]> edgeIdxInfo = new HashMap<>();
    static HashSet<String> bridge = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            graph[i] = new ArrayList<>();

        check1 = new int[N + 1];
        check2 = new int[N + 1];
        ap = new boolean[N + 1];

        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
            edgeIdxInfo.put(i + 1, new int[]{Math.min(a, b), Math.max(a, b)});
        }

        // 트리이므로 모두 연결 되어 있으므로 한번만 호출해도 됨.
        buildAP(1, 1);
        buildBridge(1, 0);

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            int k = sc.nextInt();
            // t가 1일 때는 k번 정점이 단절점인지에 대한 질의,
            // t가 2일 때는 입력에서 주어지는 k번째 간선이 단절선인지

            if (t == 1) {
                if (ap[k]) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            } else {
                int[] edge = edgeIdxInfo.get(k);
                if (bridge.contains(edge[0] + "" + edge[1])) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }

        }
    }

    static int buildAP(int s, int root) {
        check1[s] = ++time1;
        int min = time1;
        int child = 0;

        for (int adj : graph[s]) {
            if (check1[adj] == 0) {
                if (s == root)
                    child++;

                int x = buildAP(adj, root);
                min = Math.min(min, x);

                if (x >= check1[s] && s != root && !ap[s]) {
                    ap[s] = true;
                }
            } else if (min > check1[adj]) {
                min = check1[adj];
            }
        }

        if (child > 1) {
            ap[s] = true;
        }

        return min;
    }

    static int buildBridge(int s, int p) {
        check2[s] = ++time2;
        int min = time2;

        for (int adj : graph[s]) {
            if (adj == p) continue;

            if (check2[adj] == 0) {
                int x = buildBridge(adj, s);
                min = Math.min(min, x);

                if (x > check2[s]) {
                    bridge.add(Math.min(s, adj) + "" + Math.max(s, adj));
                }
            } else {
                min = Math.min(min, check2[adj]);
            }
        }

        return min;
    }
}
