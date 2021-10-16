package solve_practice_problems.Baekjoon.구현;

import java.util.Arrays;
import java.util.Scanner;

public class Sort_마스터_배지훈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        System.out.println(arr[n - 1]);
    }
}
