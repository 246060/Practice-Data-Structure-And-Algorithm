package algorithm.Backtracking;

import java.util.Scanner;

public class Baekjoon_9663 {
    // N-Queen 문제

    static int N;
    static int[] col;
    static int answer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new int[N + 1];

        backtracking(0);

        System.out.println(answer);
    }

    static void backtracking(int x) {

        if (x == N) {
            answer++;
        } else {
            for (int i = 0; i < N; i++) {
                col[x] = i;

                if (isPossible(x))
                    backtracking(x + 1);
            }
        }
    }

    static boolean isPossible(int level) {

        for (int i = 0; i < level; i++) {

            if (col[i] == col[level])
                return false;

            if (Math.abs(col[level] - col[i]) == level - i)
                return false;
        }

        return true;
    }
}
