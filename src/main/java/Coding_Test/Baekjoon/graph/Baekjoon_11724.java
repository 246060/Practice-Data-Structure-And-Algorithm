package Coding_Test.Baekjoon.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 연결 요소 (Connected Component)의 개수
public class Baekjoon_11724 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
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

        int count = 0;
        for (int i = 1; i < visited.length; i++) {
            if (visited[i]) continue;
            q.offer(i);
            count++;

            while (!q.isEmpty()) {
                int cur = q.poll();

                if (visited[cur]) continue;
                visited[cur] = true;

                for (int adj : graph.get(cur)) {
                    if (visited[adj]) continue;
                    q.offer(adj);
                }
            }
        }

        System.out.println(count);
    }
}
