package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 행렬_곱셈 {
    // 스트라센 알고리즘(Strassen Algorithm)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A_R = sc.nextInt();
        int A_C = sc.nextInt();
        int[][] a = new int[A_R][A_C];

        for (int i = 0; i < A_R; i++)
            for (int j = 0; j < A_C; j++)
                a[i][j] = sc.nextInt();

        int B_R = sc.nextInt();
        int B_C = sc.nextInt();
        int[][] b = new int[B_R][B_C];

        for (int i = 0; i < B_R; i++)
            for (int j = 0; j < B_C; j++)
                b[i][j] = sc.nextInt();

        int[][] c = new int[A_R][B_C];

        for (int i = 0; i < A_R; i++) {
            for (int j = 0; j < B_C; j++) {
                for (int k = 0; k < A_C; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        for (int i = 0; i < A_R; i++) {
            for (int j = 0; j < B_C; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }

    }
}
