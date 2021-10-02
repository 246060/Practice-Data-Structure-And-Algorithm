package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 박사_과정 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();

            if (input.equals("P=NP")) {
                System.out.println("skipped");
                continue;
            }

            String[] arr = input.split("\\+");
            System.out.println(Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]));
        }
    }
}
