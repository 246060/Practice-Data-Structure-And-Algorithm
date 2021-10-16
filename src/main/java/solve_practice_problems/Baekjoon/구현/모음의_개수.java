package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 모음의_개수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String next = sc.nextLine();
            if (next.equals("#")) break;

            next = next.toLowerCase();
            char[] chars = next.toCharArray();
            int cnt = 0;
            for (char c : chars) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
