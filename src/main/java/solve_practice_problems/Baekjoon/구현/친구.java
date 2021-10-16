package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 친구 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        boolean[][] graph = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = graph[b][a] = true;
        }

        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                if (graph[i][j]) cnt++;
            }
            System.out.println(cnt);
        }
    }
}
