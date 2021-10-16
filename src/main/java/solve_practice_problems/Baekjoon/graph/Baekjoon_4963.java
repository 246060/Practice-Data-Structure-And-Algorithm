package solve_practice_problems.Baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_4963 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            if (w == 0 && h == 0) break;

            int[][] map = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int count = search(map);
            System.out.println(count);
        }
    }

    static int search(int[][] map) {
        int count = 0;
        int w = map[0].length;
        int h = map.length;

        boolean[][] visited = new boolean[h][w];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (visited[i][j]) continue;
                if (isSea(map, i, j)) continue;
                ++count;
                q.offer(new int[]{i, j});

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int r = cur[0];
                    int c = cur[1];

                    if (c < 0 || w - 1 < c) continue;
                    if (r < 0 || h - 1 < r) continue;
                    if (isSea(map, r, c)) continue;
                    if (visited[r][c]) continue;
                    visited[r][c] = true;

                    q.offer(new int[]{r, c - 1});
                    q.offer(new int[]{r, c + 1});
                    q.offer(new int[]{r - 1, c});
                    q.offer(new int[]{r + 1, c});
                    q.offer(new int[]{r - 1, c - 1});
                    q.offer(new int[]{r - 1, c + 1});
                    q.offer(new int[]{r + 1, c - 1});
                    q.offer(new int[]{r + 1, c + 1});
                }

            }
        }

        return count;
    }

    static boolean isSea(int[][] map, int r, int c) {
        return map[r][c] == 0;
    }
}
