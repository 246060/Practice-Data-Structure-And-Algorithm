package solve_practice_problems.Baekjoon.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_2606 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int count = -1; // 첫 번째는 제외 개수

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (visited[cur])
                continue;

            visited[cur] = true;
            count++;

            for (int adj : graph.get(cur)) {
                q.offer(adj);
            }
        }

        System.out.println(count);
    }
}
