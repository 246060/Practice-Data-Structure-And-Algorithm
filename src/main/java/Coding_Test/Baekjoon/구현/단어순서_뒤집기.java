package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 단어순서_뒤집기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String answer = "";
            String[] arr = sc.nextLine().split(" ");

            for (int j = arr.length - 1; j >= 0; j--) {
                answer += arr[j] + " ";
            }

            System.out.println("Case #" + (i + 1) + ": " + answer);
        }
    }
}
