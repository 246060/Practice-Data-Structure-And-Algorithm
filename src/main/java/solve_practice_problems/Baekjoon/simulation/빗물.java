package solve_practice_problems.Baekjoon.simulation;

import java.util.Scanner;

public class 빗물 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();

        int[] hs = new int[W];
        for (int i = 0; i < W; i++) {
            hs[i] = sc.nextInt();
        }

        int answer = 0;
        int j = 0;

        while (j < W) {
            int left = Integer.MIN_VALUE;
            for (int i = j; i >= 0; i--)
                left = Math.max(left, hs[i]);

            int right = Integer.MIN_VALUE;
            for (int i = j; i < W; i++)
                right = Math.max(right, hs[i]);

            if (left > right) {
                answer += right - hs[j];
            } else {
                answer += left - hs[j];
            }
            j++;
        }

        System.out.println(answer);
    }
}
