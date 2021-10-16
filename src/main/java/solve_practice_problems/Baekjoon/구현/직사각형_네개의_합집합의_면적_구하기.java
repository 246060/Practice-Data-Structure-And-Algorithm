package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 직사각형_네개의_합집합의_면적_구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[101][101];

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int lx = sc.nextInt();
            int ly = sc.nextInt();
            int rx = sc.nextInt();
            int ry = sc.nextInt();

            for (int j = ly; j < ry; j++) {
                for (int k = lx; k < rx; k++) {
                    if (arr[j][k] == 0) {
                        arr[j][k] = 1;
                        sum++;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
