package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 그림_비교_2160 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        char[][][] map = new char[N][5][7];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = sc.nextLine().toCharArray();
            }
        }

        int[] top = new int[2];
        int cnt = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {

                int tmpCnt = 0;
                for (int t = 0; t < 5; t++) {
                    for (int k = 0; k < 7; k++) {
                        if (map[i][t][k] != map[j][t][k]) {
                            tmpCnt++;
                        }
                    }
                }

                if (cnt > tmpCnt) {
                    top[0] = i + 1;
                    top[1] = j + 1;
                    cnt = tmpCnt;
                }
            }
        }

        System.out.println(top[0] + " " + top[1]);
    }
}
