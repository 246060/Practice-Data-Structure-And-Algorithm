package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 이상한_곱셈 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        char[] A = input[0].toCharArray();
        char[] B = input[1].toCharArray();
        int n = A.length;
        int m = B.length;

        long answer = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                answer += (A[i] - '0') * (B[j] - '0');

        System.out.println(answer);
    }
}
