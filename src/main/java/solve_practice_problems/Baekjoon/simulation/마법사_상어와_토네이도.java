package solve_practice_problems.Baekjoon.simulation;

import java.util.Scanner;

public class 마법사_상어와_토네이도 {

    static int N;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static int[] ratio = {1, 1, 2, 7, 7, 2, 10, 10, 5};
    static int[][] ydy = {
            {-1, 1, -2, -1, 1, 2, -1, 1, 0, 0},
            {-1, -1, 0, 0, 0, 0, 1, 1, 2, 1},
            {-1, 1, -2, -1, 1, 2, -1, 1, 0, 0},
            {1, 1, 0, 0, 0, 0, -1, -1, -2, -1}
    };
    static int[][] xdx = {
            {1, 1, 0, 0, 0, 0, -1, -1, -2, -1},
            {-1, 1, -2, -1, 1, 2, -1, 1, 0, 0},
            {-1, -1, 0, 0, 0, 0, 1, 1, 2, 1},
            {-1, 1, -2, -1, 1, 2, -1, 1, 0, 0}
    };
    static int[][] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                A[i][j] = sc.nextInt();

        int ret = 0;
        int y = N / 2, x = N / 2, dir = 0;

        for (double i = 1.0; i <= N; i += 0.5) {
            for (int j = 0; j < (int) i; j++) {
                y += dy[dir % 4];
                x += dx[dir % 4];

                if (!inRange(y, x)) continue;
                ret += blowSand(y, x, dir);
            }
            dir++;
        }

        System.out.println(ret);
    }

    static int blowSand(int y, int x, int dir) {

        int ret = 0;
        int init = A[y][x];

        for (int i = 0; i < 10; i++) {
            int sand;
            if (i != 9) {

                sand = init * ratio[i] / 100;
                A[y][x] -= sand;
            } else {
                sand = A[y][x];
            }

            int by = y + ydy[dir % 4][i];
            int bx = x + xdx[dir % 4][i];

            if (!inRange(by, bx)) {
                ret += sand;
                continue;
            }

            A[by][bx] += sand;
        }

        A[y][x] = 0;
        return ret;
    }

    static boolean inRange(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < N;
    }
}
