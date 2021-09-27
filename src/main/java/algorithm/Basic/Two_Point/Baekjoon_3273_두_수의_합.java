package algorithm.Basic.Two_Point;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_3273_두_수의_합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int x = sc.nextInt();
        Arrays.sort(arr);

        int s = 0, e = n - 1;
        int count = 0;
        while (true) {
            if (arr[s] + arr[e] == x) {
                s++;
                e--;
                count++;
            } else if (arr[s] + arr[e] < x) {
                s++;
            } else if (arr[s] + arr[e] > x) {
                e--;
            }

            if (s >= e) {
                break;
            }
        }

        System.out.println(count);
    }
}
