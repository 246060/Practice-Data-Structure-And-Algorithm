package Coding_Test.Baekjoon.simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 로봇_청소기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 세로
        int M = sc.nextInt();

        int start_r = sc.nextInt();
        int start_c = sc.nextInt();
        int start_d = sc.nextInt(); // 0 북쪽, 1 동쪽, 2 남쪽, 3 서쪽

        int cnt = 0;

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        q.offer(new int[]{start_r, start_c, start_d});
        visited[start_r][start_c] = true;
        cnt++;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int d = cur[2];

            int nextD = d;
            for (int i = 0; i < 5; i++) {
                int[] nextPoint = null;
                int nextR, nextC;

                if (i == 4) {
                    nextPoint = backPoint(r, c, d);
                    nextR = nextPoint[0];
                    nextC = nextPoint[1];

                    if (!isValid(map, nextR, nextC)) break;
                    q.offer(new int[]{nextR, nextC, d});

                } else {
                    nextD = nextD(nextD);
                    nextPoint = nextPoint(r, c, nextD);
                    nextR = nextPoint[0];
                    nextC = nextPoint[1];

                    if (!isValid(map, nextR, nextC)) continue;
                    if (visited[nextR][nextC]) continue;
                    visited[nextR][nextC] = true;
                    q.offer(new int[]{nextR, nextC, nextD});
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }

    static final int NORTH = 0;
    static final int EAST = 1;
    static final int SOUTH = 2;
    static final int WEST = 3;

    static boolean isValid(int[][] map, int r, int c) {
        int N = map.length;
        int M = map[0].length;

        if (r < 0 || r > N - 1) return false;
        if (c < 0 || c > M - 1) return false;
        if (map[r][c] == 1) return false;

        return true;
    }

    static int nextD(int currentD) {
        switch (currentD) {
            case NORTH: return WEST;
            case EAST:  return NORTH;
            case SOUTH: return EAST;
            case WEST:  return SOUTH;
        }
        return 0;
    }

    static int[] nextPoint(int r, int c, int d) {
        switch (d) {
            case NORTH: return new int[]{r - 1, c, d};
            case EAST:  return new int[]{r, c + 1, d};
            case SOUTH: return new int[]{r + 1, c, d};
            case WEST:  return new int[]{r, c - 1, d};
        }
        return null;
    }

    static int[] backPoint(int r, int c, int d) {
        switch (d) {
            case NORTH: return new int[]{r + 1, c, d};
            case EAST:  return new int[]{r, c - 1, d};
            case SOUTH: return new int[]{r - 1, c, d};
            case WEST:  return new int[]{r, c + 1, d};
        }
        return null;
    }
}
