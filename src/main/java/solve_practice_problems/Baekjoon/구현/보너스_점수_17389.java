package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 보너스_점수_17389 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        char[] arr = sc.nextLine().toCharArray();

        int sum = 0;
        int bonus = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'O') {
                sum += (i + 1) + (bonus++);
            } else {
                bonus = 0;
            }
        }

        System.out.println(sum);
    }
}
