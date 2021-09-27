package Coding_Test.Baekjoon.simulation;

import java.util.Arrays;
import java.util.Scanner;

public class 바구니_순서_바꾸기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] basket = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            basket[i] = i;
        }

        int[] copy = Arrays.copyOf(basket, basket.length);

        for (int t = 0; t < M; t++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();

            int idx = i;
            for (int a = k; a <= j; a++) {
                copy[idx++] = basket[a];
            }
            for (int a = i; a < k; a++) {
                copy[idx++] = basket[a];
            }
            basket = Arrays.copyOf(copy, basket.length);
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(basket[i] + " ");
        }
    }
}
