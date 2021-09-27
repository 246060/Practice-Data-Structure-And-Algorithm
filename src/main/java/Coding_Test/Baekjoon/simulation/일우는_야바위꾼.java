package Coding_Test.Baekjoon.simulation;

import java.util.Scanner;

public class 일우는_야바위꾼 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int K = sc.nextInt();

        int[] cups = new int[N + 1];
        cups[X] = 1;
        for (int i = 0; i < K; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            swap(cups, from, to);
        }

        for (int i = 0; i < cups.length; i++) {
            if (cups[i] == 1) {
                System.out.println(i);
                return;
            }
        }
    }

    static void swap(int[] cups, int from, int to) {
        int tmp = cups[to];
        cups[to] = cups[from];
        cups[from] = tmp;
    }
}
