package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 방_배정_13300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] student = new int[7][2];
        for (int i = 0; i < N; i++) {
            int sex = sc.nextInt();
            int grade = sc.nextInt();
            student[grade][sex]++;
        }

        int cnt = 0;
        for (int i = 1; i < 7; i++) {
            int tmp = student[i][0];
            cnt += tmp / K;
            cnt += (tmp % K) > 0 ? 1 : 0;

            tmp = student[i][1];
            cnt += tmp / K;
            cnt += (tmp % K) > 0 ? 1 : 0;
        }

        System.out.println(cnt);
    }
}
