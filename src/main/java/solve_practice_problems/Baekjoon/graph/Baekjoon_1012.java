package solve_practice_problems.Baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_1012 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int M = sc.nextInt(); // 가로
            int N = sc.nextInt();
            int K = sc.nextInt();

            int[][] table = new int[M][N];
            for (int j = 0; j < K; j++) {
                table[sc.nextInt()][sc.nextInt()] = 1;

            }

            boolean[][] visited = new boolean[M][N];
            int count = 0;

            for (int a = 0; a < M; a++) {
                for (int b = 0; b < N; b++) {
                    if (table[a][b] == 0) continue;
                    if (visited[a][b]) continue;
                    search(table, visited, a, b);
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    static void search(int[][] table, boolean[][] visited, int r, int c) {
        int nr = table.length;
        int nc = table[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            r = cur[0];
            c = cur[1];

            if (c < 0 || nc - 1 < c) continue;
            if (r < 0 || nr - 1 < r) continue;
            if (table[r][c] == 0) continue;
            if (visited[r][c]) continue;
            visited[r][c] = true;

            q.offer(new int[]{r, c - 1});
            q.offer(new int[]{r, c + 1});
            q.offer(new int[]{r - 1, c});
            q.offer(new int[]{r + 1, c});
        }
    }
}
