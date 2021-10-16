package solve_practice_problems.Baekjoon.traversal;

import java.util.HashSet;
import java.util.Scanner;

public class 숫자판_점프 {

    static int[] path = new int[6];
    static int limit = 6;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 5;
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int cnt = 0;
                path[cnt] = map[i][j];
                traversal(map, i, j, cnt + 1);
            }
        }

        System.out.println(set.size());
    }

    private static void traversal(int[][] map, int r, int c, int cnt) {
        if (cnt == limit) {
            StringBuilder sb = new StringBuilder();
            for (int val : path) {
                sb.append(val);
            }
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < 4; i++) {
            int rr = r + dy[i];
            int cc = c + dx[i];

            if (isValid(map.length, rr, cc)) {
                path[cnt] = map[rr][cc];
                traversal(map, rr, cc, cnt + 1);
            }
        }
    }

    static boolean isValid(int n, int r, int c) {
        if (r < 0 || r > n - 1) return false;
        if (c < 0 || c > n - 1) return false;
        return true;
    }

}
