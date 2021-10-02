package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 오르막 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int before = sc.nextInt();
        while (sc.hasNextInt()) {
            int cur = sc.nextInt();
            if (before > cur) {
                System.out.println("Bad");
                return;
            }
            before = cur;
        }

        System.out.println("Good");
    }
}
