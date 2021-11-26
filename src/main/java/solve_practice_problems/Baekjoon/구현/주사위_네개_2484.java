package solve_practice_problems.Baekjoon.구현;

import java.util.Arrays;
import java.util.Scanner;

public class 주사위_네개_2484 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int[][] arr = new int[6][2];

            for (int j = 1; j <= 6; j++) {
                arr[j - 1][0] = j;
            }

            for (int j = 0; j < 4; j++) {
                int idx = sc.nextInt();
                arr[idx - 1][1]++;
            }

            Arrays.sort(arr, (o1, o2) -> {
                int c = Integer.compare(o2[1], o1[1]);
                if (c == 0) {
                    c = Integer.compare(o2[0], o1[0]);
                }
                return c;
            });

            int tmpCnt = arr[0][1];
            int tmpMax = 0;

            if (tmpCnt == 4) {
                tmpMax = 50_000 + (arr[0][0]) * 5_000;
            } else if (tmpCnt == 3) {
                tmpMax = 10_000 + (arr[0][0]) * 1_000;
            } else if (tmpCnt == 2) {
                if (arr[1][1] == 2) {
                    tmpMax = 2_000 + (arr[0][0]) * 500 + (arr[1][0]) * 500;
                } else {
                    tmpMax = 1_000 + (arr[0][0]) * 100;
                }
            } else {
                tmpMax = (arr[0][0]) * 100;
            }

            max = Math.max(max, tmpMax);
        }

        System.out.println(max);
    }
}
