package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 뒤집힌_덧셈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println(reverse(reverse(x) + reverse(y)));
    }

    static int reverse(int n) {
        int tmp = 0;
        while (n > 0) {
            tmp = tmp * 10 + n % 10;
            n /= 10;
        }
        return tmp;
    }
}
