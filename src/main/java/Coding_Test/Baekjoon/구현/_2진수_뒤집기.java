package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class _2진수_뒤집기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder(Integer.toString(N, 2));
        sb = sb.reverse();
        System.out.println(Integer.parseInt(sb.toString(), 2));
    }
}
