package Coding_Test.Baekjoon.simulation;

import java.util.Scanner;

public class 미세먼지_안녕 {

    static int[][] originMap;
    static int[][] effectedMap;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static final int AIR_CLEANER = -1;
    static final int EMPTY = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        int T = sc.nextInt();

        originMap = new int[R][C];
        effectedMap = new int[R][C];

        int idx = 0;
        int[] cleanerP = new int[2];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                originMap[i][j] = sc.nextInt();
                effectedMap[i][j] = originMap[i][j];

                if (originMap[i][j] == -1) {
                    cleanerP[idx++] = i;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            spread();
            airCycle(cleanerP);
        }

        int answer = 0;
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (originMap[i][j] != -1)
                    answer += originMap[i][j];

        System.out.println(answer);
    }

    static void airCycle(int[] cleanerP) {
        upperCycle(cleanerP[0]);
        downCycle(cleanerP[1]);
        copyMap(originMap, effectedMap);
    }

    static void upperCycle(int r) {
        int R = originMap.length;
        int C = originMap[0].length;

        for (int i = r - 1; i > 0; i--) originMap[i][0] = originMap[i - 1][0];
        for (int i = 0; i < C - 1; i++) originMap[0][i] = originMap[0][i + 1];
        for (int i = 0; i < r; i++) originMap[i][C - 1] = originMap[i + 1][C - 1];
        for (int i = C - 1; i > 1; i--) originMap[r][i] = originMap[r][i - 1];
        originMap[r][1] = 0;
    }

    static void downCycle(int r) {
        int R = originMap.length;
        int C = originMap[0].length;

        for (int i = r + 1; i < R - 1; i++) originMap[i][0] = originMap[i + 1][0];
        for (int i = 0; i < C - 1; i++) originMap[R - 1][i] = originMap[R - 1][i + 1];
        for (int i = R - 1; i > r; i--) originMap[i][C - 1] = originMap[i - 1][C - 1];
        for (int i = C - 1; i > 1; i--) originMap[r][i] = originMap[r][i - 1];
        originMap[r][1] = 0;
    }

    static void copyMap(int[][] from, int[][] to) {
        for (int i = 0; i < from.length; i++)
            for (int j = 0; j < from[0].length; j++)
                to[i][j] = from[i][j];
    }

    static void spread() {
        int R = originMap.length;
        int C = originMap[0].length;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int cur = originMap[i][j];

                if (cur != EMPTY && cur != AIR_CLEANER) {
                    for (int k = 0; k < 4; k++) {
                        int r = i + dy[k];
                        int c = j + dx[k];

                        if (inRange(R, C, r, c) && isNotAirCleaner(originMap, r, c)) {
                            int tmp = cur / 5;
                            effectedMap[r][c] += tmp;
                            effectedMap[i][j] -= tmp;
                        }
                    }
                }
            }
        }

        copyMap(effectedMap, originMap);
    }

    static boolean inRange(int R, int C, int r, int c) {
        if (0 > r || r > R - 1) return false;
        if (0 > c || c > C - 1) return false;
        return true;
    }

    static boolean isNotAirCleaner(int[][] map, int r, int c) {
        if (map[r][c] == -1) return false;
        return true;
    }
}
