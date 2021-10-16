package solve_practice_problems.Baekjoon.구현;

import java.util.Arrays;
import java.util.Scanner;

public class 삼각형_분류 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[3];

        for (int i = 0; i < T; i++) {
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            arr[2] = sc.nextInt();

            Arrays.sort(arr);

            if (arr[0] + arr[1] <= arr[2]) {
                System.out.println(String.format("Case #%d: invalid!", i + 1));
            } else if (arr[0] == arr[1] & arr[1] == arr[2]) {
                System.out.println(String.format("Case #%d: equilateral", i + 1));
            } else if (arr[0] == arr[1] || arr[1] == arr[2] || arr[2] == arr[1]) {
                System.out.println(String.format("Case #%d: isosceles", i + 1));
            } else {
                System.out.println(String.format("Case #%d: scalene", i + 1));
            }
        }
    }
}
