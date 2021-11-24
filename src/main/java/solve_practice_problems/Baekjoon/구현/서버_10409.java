package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 서버_10409 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int T = sc.nextInt();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int job = sc.nextInt();
            if (T - job >= 0) {
                T -= job;
                cnt++;
            } else {
                break;
            }
        }

        System.out.println(cnt);
    }
}
