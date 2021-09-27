package Coding_Test.Baekjoon.simulation;

import java.util.Scanner;

public class 주사위_게임 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] road = new int[N];
        for (int i = 0; i < N; i++) {
            road[i] = sc.nextInt();
        }

        int idx = 0;
        int answer = 0;
        for (int i = 0; i < M; i++) {
            int cnt = sc.nextInt();
            idx += cnt;
            answer++;

            if (idx < N) {
                idx += road[idx];
                if (idx >= N - 1) {
                    break;
                }
            } else {
                break;
            }
        }

        System.out.println(answer);
    }
}
