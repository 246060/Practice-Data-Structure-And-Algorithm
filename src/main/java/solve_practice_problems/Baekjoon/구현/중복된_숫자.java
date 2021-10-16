package solve_practice_problems.Baekjoon.구현;

import java.io.*;
import java.util.Scanner;

public class 중복된_숫자 {
    public static void main(String[] args) throws IOException {
        // solution1();
        // solution2();
        solution3();
    }

    private static byte[] buffer = new byte[78888905];
    private static int next;
    private static int b;

    static void solution3() throws IOException {
        System.in.read(buffer, 0, buffer.length);

        long N = nextInt();
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nextInt();
        }

        // sum - n(n - 1) / 2 = m
        System.out.println(sum - (N * (N - 1) / 2));
    }

    private static long nextInt() {
        long n = buffer[next++] - '0';
        while ((b = buffer[next++]) >= '0')
            n = (n * 10) + (b - '0');
        return n;
    }

    // Note: bool 이용한 풀이 : 통과 안됨
    static void solution2() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] arr = new boolean[10000000];

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (arr[x]) {
                System.out.println(x);
                break;
            }
            arr[x] = true;
        }
    }

    // Note: 비트 마스크 이용 : 통과 안됨
    static void solution1() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[10000000 / 32];

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if ((arr[x / 32] & (1 << (x % 32))) > 0) {
                System.out.println(x);
                break;
            }
            arr[x / 32] |= 1 << (x % 32);
        }
    }
}
