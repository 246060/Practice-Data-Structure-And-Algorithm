package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 오르막길 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for (int l = 0, r = 1; r < N; r++) {
            if (arr[r - 1] < arr[r]) {
                max = Math.max(max, arr[r] - arr[l]);
            } else {
                l = r;
            }
        }
        System.out.println(max == Integer.MIN_VALUE ? 0 : max);
    }
}
