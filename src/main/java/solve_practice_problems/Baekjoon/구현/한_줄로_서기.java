package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 한_줄로_서기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] line = new int[N];

        for (int i = 0; i < N; i++) {
            int left = sc.nextInt();

            for (int j = 0; j < N; j++) {
                if (left == 0 && line[j] == 0) {
                    line[j] = i + 1;
                    break;
                } else if (line[j] == 0) {
                    left--;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(line[i] + " ");
        }
    }
}
