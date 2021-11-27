package solve_practice_problems.Baekjoon.구현;

import java.util.Arrays;
import java.util.Scanner;

public class 풍선_놀이_6246 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();

        char[] arr = new char[N];
        Arrays.fill(arr, '.');
        char mark = 'a';

        for (int i = 0; i < Q; i++) {
            int start = sc.nextInt() - 1;
            int jump = sc.nextInt();

            for (int j = start; j < N; j += jump) {
                arr[j] = mark;
            }
            mark++;
        }

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '.') {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
