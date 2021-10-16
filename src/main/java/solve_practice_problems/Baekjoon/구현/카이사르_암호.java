package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 카이사르_암호 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();

        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            if (n <= 67) {
                n += 23;
            } else {
                n -= 3;
            }
            System.out.print((char) n);
        }
    }
}
