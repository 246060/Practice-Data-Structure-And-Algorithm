package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 가장_많은_글자_1371 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
            String input;
            if ((input = sc.nextLine()).equals("EOF")) {
                break;
            }
            sb.append(input);
        }

        String input = sb.toString();
        int max = 0;

        int[] arr = new int[26];
        int n = input.length();

        for (int i = 0; i < n; i++) {
            char cur = input.charAt(i);
            if ('a' <= cur && cur <= 'z') {
                int idx = input.charAt(i) - 'a';
                arr[idx]++;
                max = Math.max(max, arr[idx]);
            }
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] == max) {
                System.out.print((char) (i + 'a'));
            }
        }
    }
}
