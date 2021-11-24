package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 누울_자리를_찾아라_1652 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        int vCnt = 0, hCnt = 0;

        for (int i = 0; i < N; i++) {

            int j = 0;
            int cnt = 0;
            while (j < N) {
                if (map[i][j] == '.') {
                    cnt++;
                } else {
                    if (cnt >= 2) {
                        hCnt++;
                    }
                    cnt = 0;
                }
                j++;
            }
            if (cnt >= 2) {
                hCnt++;
            }

            j = 0;
            cnt = 0;
            while (j < N) {
                if (map[j][i] == '.') {
                    cnt++;
                } else {
                    if (cnt >= 2) {
                        vCnt++;
                    }
                    cnt = 0;
                }
                j++;
            }
            if (cnt >= 2) {
                vCnt++;
            }
        }

        System.out.println(hCnt + " " + vCnt);
    }
}
