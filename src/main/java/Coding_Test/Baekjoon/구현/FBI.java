package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class FBI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = 0;
        for (int i = 1; i <= 5; i++) {
            String agent = sc.nextLine();
            if (agent.contains("FBI")) {
                System.out.print(i + " ");
                cnt++;
            }

            if (i == 5 && cnt == 0) {
                System.out.print("HE GOT AWAY!");
            }
        }
    }
}
