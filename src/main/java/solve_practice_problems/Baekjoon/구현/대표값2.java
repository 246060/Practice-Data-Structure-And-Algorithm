package solve_practice_problems.Baekjoon.구현;

import java.util.Arrays;
import java.util.Scanner;

public class 대표값2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        System.out.println((int) Arrays.stream(nums).average().getAsDouble());
        System.out.println(nums[2]);
    }
}
