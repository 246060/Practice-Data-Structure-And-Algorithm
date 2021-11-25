package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 캔디_구매_2909 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();
        int K = sc.nextInt();

        int tmp = (int) Math.pow(10, K);
        System.out.println((C + (tmp / 2)) / tmp * tmp);
    }
}
