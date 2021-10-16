package solve_practice_problems.Baekjoon.traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 그림 {

    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int cnt = 0, max = Integer.MIN_VALUE;
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 0) continue;
                if (!visited[i][j]) {
                    max = Math.max(max, traversal(map, i, j));
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(cnt == 0 ? 0 : max);
    }

    static int traversal(int[][] map, int sr, int sc) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        visited[sr][sc] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int rr = cur[0];
            int cc = cur[1];

            for (int i = 0; i < 4; i++) {
                int rrr = rr + dy[i];
                int ccc = cc + dx[i];

                if (isValid(map, rrr, ccc)) {
                    visited[rrr][ccc] = true;
                    q.offer(new int[]{rrr, ccc});
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static boolean isValid(int[][] map, int r, int c) {
        int n = map.length;
        int m = map[0].length;
        if (0 > r || r > n - 1) return false;
        if (0 > c || c > m - 1) return false;
        if (map[r][c] == 0) return false;
        if (visited[r][c]) return false;
        return true;
    }
}
