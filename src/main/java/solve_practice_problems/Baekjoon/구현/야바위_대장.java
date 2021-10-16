package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 야바위_대장 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] arr = sc.nextLine().toCharArray();
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            swap(arr, sc.nextInt(), sc.nextInt());
        }

        System.out.println(String.valueOf(arr));
    }

    static void swap(char[] arr, int a, int b) {
        char tmp = arr[b];
        arr[b] = arr[a];
        arr[a] = tmp;
    }
}
