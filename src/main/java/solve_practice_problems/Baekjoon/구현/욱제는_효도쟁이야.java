package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 욱제는_효도쟁이야 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int s = sum;
            s -= arr[i];
            min = Math.min(min, s);
        }

        System.out.println(min);
    }
}
