package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 점수_집계 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int[] scores = new int[5];

            int mx = Integer.MIN_VALUE;
            int mn = Integer.MAX_VALUE;
            for (int j = 0; j < 5; j++) {
                scores[j] = sc.nextInt();
                mx = Math.max(mx, scores[j]);
                mn = Math.min(mn, scores[j]);
            }

            int mmx = Integer.MIN_VALUE;
            int mmn = Integer.MAX_VALUE;
            boolean mmx_flag = true;
            boolean mmn_flag = true;
            int sum = 0;
            for (int j = 0; j < 5; j++) {
                if (scores[j] == mx && mmx_flag) {
                    mmx_flag = false;
                    continue;
                }
                if (scores[j] == mn && mmn_flag) {
                    mmn_flag = false;
                    continue;
                }
                mmx = Math.max(mmx, scores[j]);
                mmn = Math.min(mmn, scores[j]);
                sum += scores[j];
            }

            if (mmx - mmn >= 4) {
                System.out.println("KIN");
            } else {
                System.out.println(sum);
            }
        }
    }
}
