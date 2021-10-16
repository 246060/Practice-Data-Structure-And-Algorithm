package solve_practice_problems.Baekjoon.traversal;

import java.util.*;

public class 데스_나이트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] map = new int[n][n];
        final int INF = (int) 1e9;
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], INF);
        }

        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        //(r-2, c-1), (r-2, c+1), (r, c-2), (r, c+2), (r+2, c-1), (r+2, c+1)
        int[] dy = {-2, -2, 0, 0, 2, 2};
        int[] dx = {-1, 1, -2, 2, -1, 1};

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r1, c1});
        visited[r1][c1] = true;
        map[r1][c1] = 1;

        int min = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            if (map[r][c] > min) {
                continue;
            }

            if (r == r2 && c == c2) {
                min = Math.min(min, map[r][c]);
                continue;
            }

            for (int i = 0; i < 6; i++) {
                int rr = r + dy[i];
                int cc = c + dx[i];

                if (isValid(map, rr, cc, visited)) {
                    visited[rr][cc] = true;
                    q.offer(new int[]{rr, cc});
                    map[rr][cc] = Math.min(map[rr][cc], map[r][c] + 1);
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min - 1);
        }
    }

    static boolean isValid(int[][] map, int r, int c, boolean[][] visited) {
        int n = map.length;
        if (0 > r || r > n - 1) return false;
        if (0 > c || c > n - 1) return false;
        if (visited[r][c]) return false;
        return true;
    }
}
