package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 주디와_당근농장_16433 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int R = sc.nextInt();
        int C = sc.nextInt();

        char[][] map = new char[N + 1][N + 1];
        int std = (R % 2) ^ (C % 2);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int tmp = (i % 2) ^ (j % 2);
                if (tmp == std) {
                    map[i][j] = 'v';
                } else {
                    map[i][j] = '.';
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }
}
