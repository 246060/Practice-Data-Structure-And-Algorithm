package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 진법_변환_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(Integer.toString(N, B).toUpperCase());
    }
}
