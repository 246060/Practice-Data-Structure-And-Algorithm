package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 진법_변환 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int B = Integer.parseInt(sc.next());

        int k = Integer.parseInt(N, B);
        System.out.println(k);
    }
}
