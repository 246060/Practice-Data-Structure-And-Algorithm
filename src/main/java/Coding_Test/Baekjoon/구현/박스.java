package Coding_Test.Baekjoon.구현;

import java.util.Arrays;
import java.util.Scanner;

public class 박스 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            int[][] map = new int[m][n];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    map[j][k] = sc.nextInt();
                }
            }
            System.out.println(getMovementCnt(map));
        }
    }

    static int getMovementCnt(int[][] map) {
        int m = map.length;
        int n = map[0].length;
        int[] height = new int[n];
        Arrays.fill(height, 1);

        int cnt = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    if (m - i != height[j]) {
                        cnt += m - i - height[j];
                        height[j]++;
                    } else if (m - i == height[j]) {
                        height[j]++;
                    }
                }
            }
        }

        return cnt;
    }
}
