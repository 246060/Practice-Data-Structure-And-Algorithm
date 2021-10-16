package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 귀여운_수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();

        int n = arr.length;
        if (n <= 2) {
            System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
            return;
        }

        for (int i = 2, d = arr[1] - arr[0]; i < n; i++) {
            if (d != arr[i] - arr[i - 1]) {
                System.out.println("흥칫뿡!! <(￣ ﹌ ￣)>");
                return;
            }
        }

        System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
    }
}
