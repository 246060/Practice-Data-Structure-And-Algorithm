package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 행렬_덧셈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] a = new int[N][M];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                a[i][j] = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append((a[i][j] + sc.nextInt()) + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
