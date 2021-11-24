package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 간지_7572 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int y = sc.nextInt();
        System.out.println((char) ('A' + ((y + 8) % 12)) + "" + ((y + 6) % 10));
    }
}
