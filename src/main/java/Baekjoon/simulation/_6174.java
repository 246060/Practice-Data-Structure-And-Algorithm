package Baekjoon.simulation;

import java.util.Arrays;
import java.util.Scanner;

public class _6174 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            char[] split = sc.nextLine().toCharArray();
            int[] a = new int[split.length];
            for (int j = 0; j < split.length; j++) {
                a[j] = split[j] - '0';
            }

            int answer = 0;
            int result = getNum(a);
            int n = a.length;

            while (result != 6174) {
                answer++;

                Arrays.sort(a);
                int min = getNum(a);

                for (int j = 0; j < n / 2; j++) {
                    int t = a[j];
                    a[j] = a[n - j - 1];
                    a[n - j - 1] = t;
                }

                int max = getNum(a);
                result = max - min;

                int tmp = result;
                for (int j = n - 1; j >= 0; j--) {
                    a[j] = tmp % 10;
                    tmp /= 10;
                }
            }

            System.out.println(answer);
        }
    }

    static int getNum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * Math.pow(10, a.length - 1 - i);
        }
        return sum;
    }
}
