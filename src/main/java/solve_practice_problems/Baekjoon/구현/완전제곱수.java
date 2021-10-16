package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 완전제곱수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int total = 0, min = Integer.MAX_VALUE;
        for (int i = M; i <= N; i++) {
            double tmp1 = Math.sqrt(i);
            int tmp2 = (int) tmp1;
            if ((double) tmp2 == tmp1) {
                total += i;
                min = Math.min(min, i);
            }
        }

        if (total != 0) {
            System.out.println(total);
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
    }
}
