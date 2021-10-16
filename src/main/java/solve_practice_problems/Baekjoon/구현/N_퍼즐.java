package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

/*
 * 문제 난이도 표시에 비해 어려운거 같다. 나중에 다시 풀어보자
 * */
public class N_퍼즐 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] arr = new char[4][4];
        for (int i = 0, k = 0; i < 4; i++) {
            arr[i] = sc.nextLine().toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr[i][j] != '.') {
                    int r = Math.abs(i - ((arr[i][j] - 'A') / 4));
                    int c = Math.abs(j - ((arr[i][j] - 'A') % 4));
                    ans += r + c;
                }
            }
        }

        System.out.println(ans);
    }
}
