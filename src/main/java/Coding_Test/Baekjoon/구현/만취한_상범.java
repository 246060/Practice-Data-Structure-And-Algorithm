package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 만취한_상범 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();

            boolean[] doors = new boolean[n + 1];
            for (int j = 1; j <= n; j++) {
                for (int k = j; k <= n; k += j) {
                    doors[k] = !doors[k];
                }
            }

            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (doors[j]) cnt++;
            }
            System.out.println(cnt);
        }
    }
}
