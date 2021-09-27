package algorithm.Graph.Articulation_Point.baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

// TODO: 해결 못함
public class 공중도시 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] check;
    static int cnt, total;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        check = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        find(1, 0);
        System.out.println(total);
    }

    static int find(int s, int p) {
        check[s] = ++cnt;
        int mn = cnt;

        for (int adj : graph.get(s)) {
            if (adj == p) continue;
            if (check[adj] == 0) {
                int x = find(adj, s);
                mn = Math.min(mn, x);
                if (x > check[s]) {
                    System.out.println(s + " " + adj);
                    total++;
                }
            } else {
                mn = Math.min(mn, check[adj]);
            }
        }
        return mn;
    }
}
