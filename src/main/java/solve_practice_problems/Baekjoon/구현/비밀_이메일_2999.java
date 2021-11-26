package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 비밀_이메일_2999 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] arr = sc.nextLine().toCharArray();
        int n = arr.length;

        int R = 0, C = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                R = i;
                C = n / R;
            }
        }

        char[][] map = new char[R][C];

        for (int i = 0, cur = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                map[j][i] = arr[cur++];
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
        }
    }
}
