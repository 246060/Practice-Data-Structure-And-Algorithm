package solve_practice_problems.Baekjoon.구현;

import java.util.Arrays;
import java.util.Scanner;

public class 카드게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a_cards = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b_cards = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int a_win = 0, b_win = 0;

        for (int i = 0; i < 10; i++) {
            if (a_cards[i] > b_cards[i]) {
                a_win++;
            } else if (a_cards[i] < b_cards[i]) {
                b_win++;
            }
        }

        if (a_win > b_win) {
            System.out.println("A");
        } else if (a_win < b_win) {
            System.out.println("B");
        } else {
            System.out.println("D");
        }
    }
}
