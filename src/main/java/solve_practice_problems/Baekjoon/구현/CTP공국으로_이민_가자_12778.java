package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class CTP공국으로_이민_가자_12778 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            String[] in = sc.nextLine().split(" ");
            int n = Integer.valueOf(in[0]);
            char t = in[1].charAt(0);

            String[] arr = sc.nextLine().split(" ");

            for (int j = 0; j < n; j++) {
                if (t == 'C') {
                    System.out.print((arr[j].charAt(0) - 'A' + 1) + " ");
                } else {
                    int m = Integer.valueOf(arr[j]);
                    System.out.print((char) ('A' + (m - 1)) + " ");
                }
            }

            System.out.println();
        }
    }
}
