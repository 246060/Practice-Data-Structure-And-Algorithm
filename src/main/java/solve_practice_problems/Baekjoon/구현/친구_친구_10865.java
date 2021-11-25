package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 친구_친구_10865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a]++;
            arr[b]++;
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(arr[i]);
        }
    }
}
