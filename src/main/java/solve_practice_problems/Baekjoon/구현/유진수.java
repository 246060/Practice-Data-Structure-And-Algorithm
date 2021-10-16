package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 유진수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        boolean flag = false;

        for (int i = 1; i < arr.length; i++) {
            int a = 1;
            for (int j = 0; j < i; j++) {
                a *= arr[j] - '0';
            }

            int b = 1;
            for (int j = i; j < arr.length; j++) {
                b *= arr[j] - '0';
            }

            if (a == b) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
