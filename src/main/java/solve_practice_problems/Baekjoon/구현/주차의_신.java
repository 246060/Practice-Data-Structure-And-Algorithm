package solve_practice_problems.Baekjoon.구현;

import java.util.Arrays;
import java.util.Scanner;

public class 주차의_신 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            int[] stores = new int[n];
            for (int j = 0; j < n; j++)
                stores[j] = sc.nextInt();

            Arrays.sort(stores);
            int dist = (stores[n - 1] - stores[0]) * 2;

            System.out.println(dist);
        }
    }
}
