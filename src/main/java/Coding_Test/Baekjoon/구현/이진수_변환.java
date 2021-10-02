package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 이진수_변환 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 100000000000000
        long a = sc.nextLong();
        System.out.println(Long.toString(a, 2));

        long b = a;
        StringBuilder sb = new StringBuilder();
        while (b > 0) {
            sb.append(b % 2);
            b /= 2;
        }
        System.out.println(sb.reverse());
    }
}
