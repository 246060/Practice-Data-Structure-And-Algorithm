package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 암호_1718 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] text = sc.nextLine().toCharArray();
        char[] key = sc.nextLine().toCharArray();

        int n = text.length;
        int m = key.length;

        for (int i = 0; i < n; i++) {
            if (text[i] == ' ') {
                System.out.print(" ");
            } else {
                int idx = text[i] - (key[i % m] + 1);
                if (idx < 0) {
                    System.out.print((char) ('z' + (idx + 1)));
                } else {
                    System.out.print((char) ('a' + idx));
                }
            }

        }
    }
}
