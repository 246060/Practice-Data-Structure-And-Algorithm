package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 선_그리기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[10001];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int j = a; j < b; j++) {
                arr[j] = 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) sum++;
        }
        System.out.println(sum);
    }
}
