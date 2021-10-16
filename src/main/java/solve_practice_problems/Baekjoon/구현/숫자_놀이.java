package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 숫자_놀이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int a = sc.nextInt();
            if (a == 0) break;

            int l = len(a);
            while (l != 1) {
                a = sum(a);
                l = len(a);
            }

            System.out.println(a);
        }
    }

    static int sum(int a) {
        int sum = 0;
        while (a > 0) {
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }

    static int len(int a) {
        int l = 0;
        while (a > 0) {
            l++;
            a /= 10;
        }
        return l;
    }
}
