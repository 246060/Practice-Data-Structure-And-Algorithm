package solve_practice_problems.Baekjoon.simulation;

import java.util.Scanner;

public class 운동 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        int R = sc.nextInt();

        int answer = 0;
        int X = m;
        while (N != 0) {
            answer++;

            if (X + T <= M) {
                X += T;
                N--;
            } else {
                X -= R;
                X = X <= m ? m : X;
            }

            if (X + T > M && X == m) {
                System.out.println("-1");
                return;
            }
        }

        System.out.println(answer);
    }
}
