package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 몬스터_트럭 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();

        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        for (int i = 0; i < 5; i++) {
            int cnt = 0;

            for (int j = 0; j < R - 1; j++) {

                out:
                for (int k = 0; k < C - 1; k++) {
                    int carCnt = 0;

                    for (int a = j; a < j + 2; a++) {
                        for (int b = k; b < k + 2; b++) {
                            if (map[a][b] == '#') continue out;
                            if (map[a][b] == 'X') carCnt++;
                        }
                    }

                    if (carCnt == i) cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}
