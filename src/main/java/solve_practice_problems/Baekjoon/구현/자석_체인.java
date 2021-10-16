package solve_practice_problems.Baekjoon.구현;

import java.util.Arrays;
import java.util.Scanner;

public class 자석_체인 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n *= 2;
        sc.nextLine();

        int[] arr = Arrays.stream(sc.nextLine().split(""))
                          .mapToInt(Integer::parseInt)
                          .toArray();

        int before = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] != before) {
                before = arr[i];
            } else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
