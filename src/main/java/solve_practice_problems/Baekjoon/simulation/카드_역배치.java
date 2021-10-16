package solve_practice_problems.Baekjoon.simulation;

import java.util.Scanner;

public class 카드_역배치 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[21];
        for (int i = 1; i <= 20; i++)
            arr[i] = i;

        for (int i = 0; i < 10; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            for (int j = l; j <= l + (r - l) / 2; j++) {
                int tmp = arr[j];
                arr[j] = arr[l + r - j];
                arr[l + r - j] = tmp;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
