package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 배수들의_합 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] ks = new int[M];
        for (int i = 0; i < M; i++) {
            ks[i] = sc.nextInt();
        }

        int sum = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if (i % ks[j] == 0) {
                    sum += i;
                    break;
                }
            }
        }

        System.out.println(sum);
    }
}