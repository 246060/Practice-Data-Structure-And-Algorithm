package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 방_번호 {

    static int cnt;
    static int[] plastic = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        buySet();

        while (N > 0) {
            int a = N % 10;
            N /= 10;

            if (a == 9) a = 6;
            if (plastic[a] == 0) buySet();

            plastic[a]--;
        }

        System.out.println(cnt);
    }

    static void buySet() {
        cnt++;
        for (int i = 0; i < 10; i++) {
            if (i == 9) {
                plastic[6]++;
            } else {
                plastic[i]++;
            }
        }
    }

}
