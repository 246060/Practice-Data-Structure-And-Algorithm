package solve_practice_problems.Baekjoon.simulation;

import java.util.Scanner;

public class 바구니_뒤집기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] basket = new int[N + 1];
        for (int i = 0; i <= N; i++)
            basket[i] = i;

        for (int k = 0; k < M; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            for (int l = i; l <= i + (j - i) / 2; l++) {
                int tmp = basket[l];
                basket[l] = basket[i + j - l];
                basket[i + j - l] = tmp;
            }
        }

        for (int i = 1; i <= N; i++)
            System.out.print(basket[i] + " ");
    }
}
