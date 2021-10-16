package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 지속 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        while (n > 9) {
            int a = n;
            int b = 1;
            while (a > 0) {
                b *= a % 10;
                a /= 10;
            }
            n = b;
            cnt++;
        }

        System.out.println(cnt);
    }
}
