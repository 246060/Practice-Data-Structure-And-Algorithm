package Coding_Test.Baekjoon.구현;

import java.util.Arrays;
import java.util.Scanner;

public class 한다_안한다 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            int[] nums = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
            int len = nums.length;
            int a = len / 2 - 1;
            int b = a + 1;

            if (nums[a] == nums[b]) {
                System.out.println("Do-it");
            } else {
                System.out.println("Do-it-Not");
            }
        }

    }
}
