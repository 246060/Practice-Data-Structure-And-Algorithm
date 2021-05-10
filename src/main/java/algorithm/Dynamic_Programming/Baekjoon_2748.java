package algorithm.Dynamic_Programming;

import java.util.Scanner;

public class Baekjoon_2748 {
    //피보나치 수 2

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long a = 0;
        long b = 1;

        if (n == 0) b = a;

        for (int i = 2; i <= n; i++) {
            long tmp = b;
            b += a;
            a = tmp;
        }

        System.out.println(b);
    }
}
