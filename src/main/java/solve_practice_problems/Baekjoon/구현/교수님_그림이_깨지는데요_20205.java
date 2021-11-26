package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 교수님_그림이_깨지는데요_20205 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int M = N * K;

        int[][] map = new int[M][M];
        int a = 0, b = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++, b += K) {
                int t = sc.nextInt();
                for (int r = a; r < a + K; r++) {
                    for (int c = b; c < b + K; c++) {
                        map[r][c] = t;
                    }
                }
            }
            b = 0;
            a += K;
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
