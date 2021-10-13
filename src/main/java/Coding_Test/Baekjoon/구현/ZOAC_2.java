package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class ZOAC_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] word = sc.nextLine().toCharArray();

        int cnt = 0;
        int s = 0;

        for (int i = 0; i < word.length; i++) {
            int a = word[i] - 'A';
            int leftCnt = 0, rightCnt = 0;

            int tmp = s;
            while (tmp != a) {
                tmp--;
                leftCnt++;
                if (tmp < 0) tmp = 25;
            }

            tmp = s;
            while (tmp != a) {
                tmp++;
                rightCnt++;
                if (tmp > 25) tmp = 0;
            }

            cnt += Math.min(leftCnt, rightCnt);
            s = a;
        }
        System.out.println(cnt);
    }
}
