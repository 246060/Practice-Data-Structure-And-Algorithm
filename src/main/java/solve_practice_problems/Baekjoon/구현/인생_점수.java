package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 인생_점수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            int sum = 0;
            char[] arr = sc.nextLine().toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == ' ') continue;
                sum += arr[j] - 'A' + 1;
            }

            if (sum == 100) {
                System.out.println("PERFECT LIFE");
            } else {
                System.out.println(sum);
            }
        }

    }
}
