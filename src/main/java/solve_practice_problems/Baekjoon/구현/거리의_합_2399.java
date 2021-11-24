package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 거리의_합_2399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.abs(arr[i] - arr[j]);
            }
        }

        System.out.println(sum);
    }
}
