package Coding_Test.Baekjoon.simulation;

import java.util.Scanner;

public class 공_바꾸기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] basket = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            basket[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            int tmp = basket[to];
            basket[to] = basket[from];
            basket[from] = tmp;
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(basket[i] + " ");
        }
    }
}
