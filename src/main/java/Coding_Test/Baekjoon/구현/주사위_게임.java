package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 주사위_게임 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;

        for (int i = 0; i < N; i++) {

            int[] nums = new int[7];
            int maxCount = 0;
            int idx = 0;

            for (int j = 0; j < 3; j++) {
                int a = sc.nextInt();
                nums[a]++;

                if (maxCount < nums[a]) {
                    maxCount = nums[a];
                    idx = a;
                }
            }

            int score = 0;
            if (maxCount == 1) {
                for (int j = 1; j < nums.length; j++) {
                    if (nums[j] > 0)
                        idx = j;
                }
                score = idx * 100;

            } else if (maxCount == 2) {
                score = 1_000 + (idx * 100);

            } else if (maxCount == 3) {
                score = 10_000 + (idx * 1_000);
            }

            result = Math.max(result, score);
        }

        System.out.println(result);
    }
}
