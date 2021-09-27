package algorithm.Basic.Two_Point;

import java.util.Scanner;

// TODO: 해결하지 못함.
public class Baekjoon_22114_창영이와_점프 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int s = 0, e = 0, count = 1, chance = 1;

        while (true) {
            if (e >= arr.length) break;

            if (arr[e] > K && chance == 1) {
                count++;
                chance--;
                e++;
            } else if (arr[e] > K && chance == 0) {
                count = 1;
                chance = 1;
                s = e;
            } else {
                e++;
                count++;
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}
