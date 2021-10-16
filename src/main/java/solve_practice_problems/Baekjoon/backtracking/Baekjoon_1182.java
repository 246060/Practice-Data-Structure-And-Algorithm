package solve_practice_problems.Baekjoon.backtracking;

import java.util.Scanner;

public class Baekjoon_1182 {
    static int answer = 0;
    static int S;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
            5 0
            -7 -3 -2 5 8
         */
        int N = sc.nextInt();
        S = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        backtracking(0, 0);
        System.out.println(answer);
    }

    static void backtracking(int level, int sum) {

        if (arr.length == level)
            return;

        if (sum == S && level != 0)
            answer++;

        for (int i = level; i < arr.length; i++)
            backtracking(i + 1, sum + arr[i]);
    }
}
