package solve_practice_problems.Baekjoon.simulation;

import java.util.Scanner;

public class 돌려_돌려_돌림판 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            sc.nextLine();
            int X = Integer.parseInt(sc.nextLine().replaceAll(" ", ""));
            int Y = Integer.parseInt(sc.nextLine().replaceAll(" ", ""));
            String board = sc.nextLine().replaceAll(" ", "");
            board += board;

            int answer = 0;
            for (int i = 0; i < N; i++) {
                String tmp = board.substring(i, i + M);
                int Z = Integer.parseInt(tmp);
                if (X <= Z && Z <= Y) {
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }
}
