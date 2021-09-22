package Baekjoon.dp.LIS;

import java.util.Scanner;

public class 가장_긴_바이토닉_부분_수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int[] toRight = new int[N];
        for (int i = 0; i < N; i++) {
            toRight[i] = 1;
            for (int j = 0; j < i; j++)
                if (arr[j] < arr[i])
                    toRight[i] = Math.max(toRight[i], toRight[j] + 1);
        }

        int[] toLeft = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            toLeft[i] = 1;
            for (int j = N - 1; j > i; j--)
                if (arr[j] < arr[i])
                    toLeft[i] = Math.max(toLeft[i], toLeft[j] + 1);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++)
            max = Math.max(max, toRight[i] + toLeft[i] - 1);

        System.out.println(max);
    }
}
