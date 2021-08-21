package algorithm.Two_Point;

import java.util.Scanner;

public class Baekjoon_2003_수들의_합_2 {

    public static void main(String[] args) {

        int N, M;
        int[] arr;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int s = 0, e = 0;
        int sum = 0, result = 0;

        while (true) {
            if (sum >= M) {
                sum -= arr[s++];
            } else if (e >= N) {
                break;
            } else {
                sum += arr[e++];
            }
            if (sum == M) result++;
        }

        System.out.println("result : " + result);
    }
}
