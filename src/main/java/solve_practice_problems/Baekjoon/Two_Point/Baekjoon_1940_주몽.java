package solve_practice_problems.Baekjoon.Two_Point;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_1940_주몽 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int s = 0, e = N - 1;
        int count = 0;
        while (true) {
            if (arr[s] + arr[e] == M) {
                s++;
                e--;
                count++;
            } else if (arr[s] + arr[e] < M) {
                s++;
            } else if (arr[s] + arr[e] > M) {
                e--;
            }
            if (s >= e) break;
        }

        System.out.println(count);
    }
}
