package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class Cryptoquote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            char[] sentence = sc.nextLine().toCharArray();
            char[] rule = sc.nextLine().toCharArray();

            for (int j = 0; j < sentence.length; j++) {
                if (sentence[j] == ' ') {
                    System.out.print(sentence[j]);
                } else {
                    System.out.print((rule[sentence[j] - 'A']));
                }
            }
            System.out.println();

        }
    }
}
