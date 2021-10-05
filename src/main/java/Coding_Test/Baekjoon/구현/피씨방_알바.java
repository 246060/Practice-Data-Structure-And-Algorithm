package Coding_Test.Baekjoon.구현;

import java.util.HashSet;
import java.util.Scanner;

public class 피씨방_알바 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int seat = sc.nextInt();
            set.add(seat);
        }

        System.out.println(N - set.size());
    }
}
