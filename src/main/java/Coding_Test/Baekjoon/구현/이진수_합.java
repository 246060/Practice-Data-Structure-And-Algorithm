package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 이진수_합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) sb.append(1);
        for (int i = 1; i < K; i++) sb.append(0);
        System.out.println(sb);
    }
}
