package Baekjoon.simulation;

import java.util.Scanner;

public class 컨베이어_벨트_위의_로봇 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] conveyor = new int[2 * N];
        boolean[] robots = new boolean[2 * N];

        for (int i = 0; i < 2 * N; i++) {
            conveyor[i] = sc.nextInt();
        }

        int cnt = 0;
        while (isRun(conveyor, K)) {
            cnt++;

            rotateConveyor(conveyor);
            rotateRobots(robots);
            robots[N - 1] = false;

            for (int i = N - 1; i > 0; i--) {
                if (robots[i - 1] && !robots[i] && conveyor[i] >= 1) {
                    robots[i] = robots[i - 1];
                    robots[i - 1] = false;
                    conveyor[i]--;
                }
            }
            robots[N - 1] = false;

            if (conveyor[0] > 0) {
                conveyor[0]--;
                robots[0] = true;
            }
        }

        System.out.println(cnt);
    }

    static void rotateConveyor(int[] conveyor) {
        int tmp = conveyor[conveyor.length - 1];
        for (int i = conveyor.length - 1; i >= 1; i--) {
            conveyor[i] = conveyor[i - 1];
        }
        conveyor[0] = tmp;
    }

    static void rotateRobots(boolean[] robots) {
        boolean tmp = robots[robots.length - 1];
        for (int i = robots.length - 1; i >= 1; i--) {
            robots[i] = robots[i - 1];
        }
        robots[0] = tmp;
    }

    static boolean isRun(int[] conveyor, int K) {
        int cnt = 0;
        for (int i = 0; i < conveyor.length; i++) {
            if (conveyor[i] == 0)
                cnt++;
        }
        return cnt < K ? true : false;
    }
}
