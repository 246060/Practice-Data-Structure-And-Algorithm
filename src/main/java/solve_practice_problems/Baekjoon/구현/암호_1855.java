package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 암호_1855 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        sc.nextLine();
        char[] arr = sc.nextLine().toCharArray();

        char[][] map = new char[arr.length / K][K];

        int cur = 0;
        int r = 0, c = 0;

        int n = map.length;
        int m = K;

        map[r][c] = arr[cur++];
        while (cur != arr.length) {
            while (c + 1 < m && cur < arr.length) {
                map[r][++c] = arr[cur++];
            }
            if (r + 1 < n && cur < arr.length) {
                map[++r][c] = arr[cur++];
            }
            while (c - 1 >= 0 && cur < arr.length) {
                map[r][--c] = arr[cur++];
            }
            if (r + 1 < n && cur < arr.length) {
                map[++r][c] = arr[cur++];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                sb.append(map[i][j]);
            }
        }
        System.out.println(sb.toString());

    }
}
