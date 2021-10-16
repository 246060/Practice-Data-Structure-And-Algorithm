package solve_practice_problems.Baekjoon.simulation;

import java.util.Scanner;

public class 헤일스톤_수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int max = Integer.MIN_VALUE;

            while (true) {
                max = Math.max(max, n);
                if (n == 1) break;

                if (n % 2 == 1) {
                    n = 3 * n + 1;
                } else {
                    n /= 2;
                }
            }

            System.out.println(max);
        }
    }
}
