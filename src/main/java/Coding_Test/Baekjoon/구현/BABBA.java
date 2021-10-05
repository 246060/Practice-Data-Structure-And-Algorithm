package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class BABBA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        int A = 1, B = 0;
        for (int i = 0; i < K; i++) {
            int a = A;
            int b = B;
            B += a;
            A -= a;
            A += b;
        }
        System.out.println(A + " " + B);
    }
}
