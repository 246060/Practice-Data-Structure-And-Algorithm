package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 방_배정 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] rooms = new int[5];

        for (int i = 0; i < N; i++) {
            int S = sc.nextInt(); // 여:0, 남:1
            int Y = sc.nextInt();
            if (Y == 1 || Y == 2) {
                rooms[0]++;
            } else if (Y == 3 || Y == 4) {
                if (S == 0) {
                    rooms[1]++;
                } else {
                    rooms[2]++;
                }
            } else {
                if (S == 0) {
                    rooms[3]++;
                } else {
                    rooms[4]++;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < rooms.length; i++) {
            int tmp = rooms[i];
            cnt += tmp / K;
            tmp %= K;
            if (tmp != 0) {
                cnt += 1;
            }
        }

        System.out.println(cnt);
    }
}
