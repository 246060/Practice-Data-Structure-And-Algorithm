package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 수퍼_마리오 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            if (Math.abs(100 - sum) >= Math.abs(100 - (sum + arr[i]))) {
                sum += arr[i];
            } else {
                break;
            }
        }
        System.out.println(sum);
    }
}
