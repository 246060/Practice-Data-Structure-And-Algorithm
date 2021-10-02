package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 럭키_스트레이트 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.nextLine();
        int m = N.length() / 2;

        String[] left = N.substring(0, m).split("");
        String[] right = N.substring(m).split("");

        int n = left.length;
        int lSum = 0, rSum = 0;
        for (int i = 0; i < n; i++) {
            lSum += Integer.parseInt(left[i]);
            rSum += Integer.parseInt(right[i]);

            if (n - 1 == i) {
                if (lSum == rSum) {
                    System.out.println("LUCKY");
                } else {
                    System.out.println("READY");
                }
            }
        }

    }
}
