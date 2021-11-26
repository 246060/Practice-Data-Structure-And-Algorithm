package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 삼각_김밥_2783 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int Y = sc.nextInt();
        double min = X * 1.0 / Y;

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int _X = sc.nextInt();
            int _Y = sc.nextInt();
            min = Math.min(min, _X * 1.0 / _Y);
        }

        System.out.println(min * 1000);
    }
}
