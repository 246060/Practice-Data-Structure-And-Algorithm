package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 주식_투자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();

            int sum = 0;
            for (int j = 0; j < n; j++) {
                int max = Integer.MIN_VALUE;
                for (int k = 0; k < 3; k++) {
                    max = Math.max(max, sc.nextInt());
                }

                if (max < 0)
                    max = 0;

                sum += max;
            }

            System.out.println(sum);
        }
    }
}
