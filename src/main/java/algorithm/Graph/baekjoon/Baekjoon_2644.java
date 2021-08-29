package algorithm.Graph.baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_2644 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int e = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int _s = sc.nextInt();
            int _e = sc.nextInt();
            graph.get(_s).add(_e);
            graph.get(_e).add(_s);
        }

        boolean[] visited = new boolean[n + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{s, 0});

        int count = -1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int p = cur[0];
            int _count = cur[1];

            if (visited[p]) continue;
            visited[p] = true;

            if (p == e) {
                count = _count;
                break;
            }

            for (int adj : graph.get(p)) {
                if (visited[adj]) continue;
                q.offer(new int[]{adj, _count + 1});
            }
        }

        System.out.println(count);
    }
}
