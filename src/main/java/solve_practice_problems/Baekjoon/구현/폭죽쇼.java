package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 폭죽쇼 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();

        int[] arr = new int[C + 1];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            for (int j = a; j <= C; j += a) {
                if (arr[j] == 0) {
                    arr[j]++;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
