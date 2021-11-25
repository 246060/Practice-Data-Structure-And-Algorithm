package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 줄_세우기_1681 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();
        int cnt = 0, i = 0;

        while (cnt != N) {
            while (isContain(++i, L)) {
            }
            cnt++;
        }
        System.out.println(i);
    }

    private static boolean isContain(int num, int L) {
        while (num > 0) {
            if (num % 10 == L) {
                return true;
            }
            num /= 10;
        }
        return false;
    }
}
