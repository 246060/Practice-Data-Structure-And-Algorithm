package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 핸드폰_번호_궁합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] a1 = sc.nextLine().toCharArray();
        char[] a2 = sc.nextLine().toCharArray();

        int[] arr = new int[a1.length * 2];
        for (int i = 0, j = 0; i < a1.length; i++) {
            arr[j++] = a1[i] - '0';
            arr[j++] = a2[i] - '0';
        }

        int[] tmp;
        int len = arr.length;

        while (len != 2) {
            tmp = new int[arr.length - 1];

            for (int i = 0; i < tmp.length; i++) {
                tmp[i] = (arr[i] + arr[i + 1]) % 10;
            }

            arr = tmp;
            len = arr.length;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
