package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 노래_악보 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();

        int[] arr = new int[10001];
        int a = 0, b = 0, order = 0;

        for (int i = 0; i < N; i++) {
            b = sc.nextInt();
            order++;
            for (int k = a; k < (a + b); k++) {
                arr[k] = order;
            }
            a += b;
        }

        for (int i = 0; i < Q; i++) {
            int q = sc.nextInt();
            System.out.println(arr[q]);
        }
    }
}
