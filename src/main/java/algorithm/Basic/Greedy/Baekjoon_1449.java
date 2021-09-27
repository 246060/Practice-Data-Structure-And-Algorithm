package algorithm.Basic.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_1449 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int end = arr[0] + (L - 1);
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= end) {
                continue;
            } else {
                count++;
                end = arr[i] + (L - 1);
            }
        }

        System.out.println(count);
    }

}
