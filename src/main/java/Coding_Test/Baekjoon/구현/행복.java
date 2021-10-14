package Coding_Test.Baekjoon.구현;

import java.util.Arrays;
import java.util.Scanner;

public class 행복 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        System.out.println(arr[n - 1] - arr[0]);
    }
}
