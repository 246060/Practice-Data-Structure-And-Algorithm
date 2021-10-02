package Coding_Test.Baekjoon.구현;

import java.util.Arrays;
import java.util.Scanner;

public class 신용카드_판별 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            int[] cards = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();

            for (int j = 14; j >= 0; j -= 2) {
                int tmp = cards[j] * 2;
                if (tmp > 9) {
                    int a = tmp % 10;
                    tmp /= 10;
                    a += tmp % 10;
                    tmp = a;
                }
                cards[j] = tmp;
            }

            int sum = Arrays.stream(cards).sum();
            System.out.println(sum % 10 == 0 ? "T" : "F");
        }
    }
}
