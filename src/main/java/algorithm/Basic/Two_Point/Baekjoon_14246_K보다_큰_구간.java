package algorithm.Basic.Two_Point;

import java.util.Scanner;

// TODO : 해결하지 못함. 인터넷에도 문제 풀이 못찾음.
public class Baekjoon_14246_K보다_큰_구간 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        int k = sc.nextInt();

        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            long tmpSum = sum;
            for (int j = n - 1; i < j; j--) {
                if (tmpSum > k) {
                    count++;
                } else {
                    break;
                }
                tmpSum -= arr[j];
            }
            sum -= arr[i];
        }

        System.out.println(count);
    }
}
