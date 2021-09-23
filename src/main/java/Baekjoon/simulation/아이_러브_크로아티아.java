package Baekjoon.simulation;

import javax.swing.*;
import java.util.Scanner;

public class 아이_러브_크로아티아 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();

        int limit = 210;
        int total = 0;

        for (int i = 0; i < N; i++) {
            String[] split = sc.nextLine().split(" ");
            int sec = Integer.parseInt(split[0]);
            String Z = split[1];

            total += sec;
            if (total >= limit) {
                System.out.println(K);
                return;
            }

            if (Z.equals("T")) {
                K++;
                K %= 8;
                K = K == 0 ? 8 : K;
            }
        }
    }
}
