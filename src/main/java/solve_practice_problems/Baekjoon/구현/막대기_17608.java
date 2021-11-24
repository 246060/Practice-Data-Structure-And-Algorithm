package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 막대기_17608 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt = 1;
        int max = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (max < arr[i]) {
                max = arr[i];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
