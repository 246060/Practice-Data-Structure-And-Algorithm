package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 패리티 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();
            if ("#".equals(line)) break;

            char[] arr = line.toCharArray();
            int one_cnt = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == '1')
                    one_cnt++;
            }

            int n = arr.length;
            char eo = arr[n - 1];
            if (eo == 'e') {
                if (one_cnt % 2 == 1) {
                    arr[n - 1] = '1';
                } else {
                    arr[n - 1] = '0';
                }
            } else if (eo == 'o') {
                if (one_cnt % 2 == 1) {
                    arr[n - 1] = '0';
                } else {
                    arr[n - 1] = '1';
                }
            }

            System.out.println(String.valueOf(arr));
        }
    }
}
