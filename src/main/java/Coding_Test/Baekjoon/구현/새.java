package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 새 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int cnt = 0;
        int fly = 0;
        while (N > 0) {
            cnt++;
            if (N < fly + 1) {
                fly = 1;
                N -= fly;
            } else {
                N -= ++fly;
            }
        }
        System.out.println(cnt);
    }
}
