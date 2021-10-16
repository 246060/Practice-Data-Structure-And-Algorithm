package solve_practice_problems.Baekjoon.greedy;

import java.util.Scanner;

public class Baekjoon_1439 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();

        int one = 0, zero = 0;

        if (arr[0] == '0')
            zero++;
        else
            one++;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                if (arr[i] == '0')
                    zero++;
                else
                    one++;
            }
        }

        System.out.println(Math.min(zero, one));

    }
}
