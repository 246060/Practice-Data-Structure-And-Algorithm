package Coding_Test.Baekjoon.simulation;

import java.util.Scanner;

public class 로봇 {

    // 시작점이 아래쪽이라 북남 방향 바꿈.
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();

        int[] current = {0, 0, 0};
        for (int i = 0; i < n; i++) {
            String[] split = sc.nextLine().split(" ");
            String command = split[0];
            int num = Integer.parseInt(split[1]);

            if (command.equals("TURN")) {
                current[2] = turn(current[2], num);
            } else {
                for (int j = 0; j < num; j++) {
                    current[1] += dx[current[2]];
                    current[0] += dy[current[2]];
                    if (!inRange(current, M)) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        if (!inRange(current, M)) {
            System.out.println(-1);
        } else {
            System.out.println(current[1] + " " + current[0]);
        }
    }

    static boolean inRange(int[] current, int m) {
        int r = current[0];
        int c = current[1];
        if (0 > r || r > m - 1) return false;
        if (0 > c || c > m - 1) return false;
        return true;
    }

    static int turn(int currentD, int num) {
        // EAST = 0, SOUTH = 1, WEST = 2, NORTH = 3
        if (num == 0) {
            // 왼쪽 90
            currentD--;
            if (currentD < 0)
                currentD = 3;
        } else {
            // 오른쪽 90
            currentD++;
            if (currentD > 3)
                currentD = 0;
        }
        return currentD;
    }
}
