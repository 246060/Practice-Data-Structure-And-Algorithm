package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 색종리_2563 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] map = new int[101][101];

        for (int i = 0; i < n; i++) {
            int lp = sc.nextInt();
            int bp = sc.nextInt();

            for (int j = lp; j < lp + 10; j++) {
                for (int k = bp; k < bp + 10; k++) {
                    map[j][k] = 1;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (map[i][j] == 1) {
                    sum++;
                }
            }
        }

        System.out.println(sum);
    }
}
