package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 상금_헌터_15953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] money1 = {500, 300, 200, 50, 30, 10};
        int[] money2 = {512, 256, 128, 64, 32};

        int[] aArr = new int[101];
        int[] bArr = new int[65];

        int cur = 1;
        for (int i = 0, j = 1; i < 6; i++, j++) {
            for (int k = cur; k < cur + j; k++) {
                aArr[k] = money1[i];
            }
            cur += j;
        }

        cur = 1;
        for (int i = 0, j = 1; i < 5; i++, j *= 2) {
            for (int k = cur; k < cur + j; k++) {
                bArr[k] = money2[i];
            }
            cur += j;
        }

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int sum = aArr[a] + bArr[b];
            System.out.println(sum * 10000);
        }
    }
}
