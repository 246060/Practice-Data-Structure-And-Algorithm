package algorithm.Greedy;

import java.util.Scanner;

public class Baekjoon_1783 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        if (N == 1) {
            System.out.println(1);
        } else if (N == 2) {
            System.out.println(Math.min(4, (M + 1) / 2));
        } else if (M < 7) {
            System.out.println(Math.min(4, M));
        } else {
            System.out.println(M - 7 + 5);
        }
    }
}
