package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 달팽이2_1952 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] arr = new int[M][N];

        int r = 0, c = 0, d = 0;
        arr[r][c] = 1;

        int cnt = 0;
        boolean isDoing = true;

        while (true) {
            isDoing = false;

            while (c + 1 < N && arr[r][c + 1] != 1) {
                arr[r][++c] = 1;
                cnt += d == 1 ? 1 : 0;
                d = 0;
                isDoing = true;
            }
            while (r + 1 < M && arr[r + 1][c] != 1) {
                arr[++r][c] = 1;
                cnt += d == 0 ? 1 : 0;
                d = 1;
                isDoing = true;
            }
            while (c - 1 >= 0 && arr[r][c - 1] != 1) {
                arr[r][--c] = 1;
                cnt += d == 1 ? 1 : 0;
                d = 0;
                isDoing = true;
            }
            while (r - 1 >= 0 && arr[r - 1][c] != 1) {
                arr[--r][c] = 1;
                cnt += d == 0 ? 1 : 0;
                d = 1;
                isDoing = true;
            }

            if (!isDoing) {
                break;
            }
        }

        System.out.println(cnt);


    }
}
