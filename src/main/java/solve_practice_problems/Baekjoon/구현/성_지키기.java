package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 성_지키기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        int[] rows = new int[N];
        int[] cols = new int[M];

        for (int i = 0; i < N; i++) {
            char[] arr = sc.nextLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (arr[j] == 'X') {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        int cnt = 0;
        int i = 0, j = 0;
        while (i < N || j < M) {

            boolean flag = false;
            for (; i < N; i++) {
                if (rows[i] == 0) {
                    rows[i]++;
                    flag = true;
                    break;
                }
            }

            for (; j < M; j++) {
                if (cols[j] == 0) {
                    cols[j]++;
                    flag = true;
                    break;
                }
            }

            if (flag) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
