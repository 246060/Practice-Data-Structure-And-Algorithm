package Coding_Test.Baekjoon.dp;

import java.util.Scanner;

public class 돌_게임_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N % 2 == 1) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}
