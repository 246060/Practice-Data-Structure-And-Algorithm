package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class Quicksum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String str = sc.nextLine();
            if (str.equals("#")) break;

            char[] arr = str.toCharArray();
            int sum = 0;
            int n = arr.length;

            for (int i = 0; i < n; i++) {
                if (arr[i] == ' ') continue;
                sum += (arr[i] - 'A' + 1) * (i + 1);
            }

            System.out.println(sum);
        }
    }
}
