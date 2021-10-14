package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 팰린드룸 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] arr = sc.nextLine().toCharArray();
        int n = arr.length;

        for (int s = 0, e = n - 1; s < e; s++, e--) {
            if (arr[s] != arr[e]) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }
}
