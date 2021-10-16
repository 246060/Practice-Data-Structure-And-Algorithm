package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 아기_석환_뚜루루_뚜루 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String song = "baby sukhwan tururu turu\n" +
                "very cute tururu turu\n" +
                "in bed tururu turu\n" +
                "baby sukhwan";

        String[] words = song.split("\\s");
        int k = (N - 1) / words.length;
        int cursor = (N - 1) % words.length;

        String answer = words[cursor];
        if (answer.equals("tururu")) {
            if (2 + k >= 5) {
                answer = "tu+ru*" + (2 + k);
            } else {
                while (k-- > 0) answer += "ru";
            }
        } else if (answer.equals("turu")) {
            if (1 + k >= 5) {
                answer = "tu+ru*" + (1 + k);
            } else {
                while (k-- > 0) answer += "ru";
            }
        }

        System.out.println(answer);
    }
}
