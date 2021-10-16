package solve_practice_problems.Baekjoon.simulation;

import java.util.Scanner;

public class 도로와_신호등 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();

        int time = 0;
        int beforeD = 0;
        for (int i = 0; i < N; i++) {
            int D = sc.nextInt();
            int R = sc.nextInt();
            int G = sc.nextInt();
            time += (D - beforeD);
            beforeD = D;
            int tmp = time % (R + G);
            if (tmp < R) {
                time += R - tmp;
            }
        }
        time += (L - beforeD);
        System.out.println(time);
    }

}
