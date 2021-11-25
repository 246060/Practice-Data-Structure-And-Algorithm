package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 나는_학급회장이다_2456 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[3];
        int[] multiArr = new int[3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                int score = sc.nextInt();
                arr[j] += score;
                multiArr[j] += score * score;
            }
        }

        int idx = 0;
        int max = getMax(arr);
        if (getMaxCount(arr) == 1) {
            idx = getMaxIdx(arr);
            System.out.println((idx + 1) + " " + max);
        } else if (getMaxCount(multiArr) == 1) {
            idx = getMaxIdx(multiArr);
            System.out.println((idx + 1) + " " + max);
        } else {
            System.out.println(idx + " " + max);
        }
    }

    private static int getMaxCount(int[] arr) {
        int cnt = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                cnt = 1;
            } else if (max == arr[i]) {
                cnt++;
            }
        }
        return cnt;
    }

    private static int getMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    private static int getMaxIdx(int[] arr) {
        int idx = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                idx = i;
            }
        }
        return idx;
    }
}
