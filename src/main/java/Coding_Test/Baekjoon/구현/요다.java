package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 요다 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String[] words = sc.nextLine().split(" ");
            for (int j = 2; j < words.length; j++) {
                System.out.print(words[j] + " ");
            }
            System.out.print(words[0] + " ");
            System.out.println(words[1]);
        }
    }
}
