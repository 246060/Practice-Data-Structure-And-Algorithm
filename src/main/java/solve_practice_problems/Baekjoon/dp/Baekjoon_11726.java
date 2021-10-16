package solve_practice_problems.Baekjoon.dp;

import java.util.Scanner;

public class Baekjoon_11726 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++) {
            int t = b;
            b = (b + a) % 10_007;
            a = t;
        }

        System.out.println(n == 1 ? a : b);
    }

}
