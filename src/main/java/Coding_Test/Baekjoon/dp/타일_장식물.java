package Coding_Test.Baekjoon.dp;

import java.util.Scanner;

public class 타일_장식물 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 1) {
            System.out.println(4);
            return;
        }

        long[] arr = new long[n];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        long a = arr[n - 1];
        long b = arr[n - 2] + arr[n - 1];
        long sum = 0;

        sum += a * 2;
        sum += b * 2;

        System.out.println(sum);
    }
}
