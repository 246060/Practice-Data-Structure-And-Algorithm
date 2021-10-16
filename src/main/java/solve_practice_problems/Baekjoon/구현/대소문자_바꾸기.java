package solve_practice_problems.Baekjoon.구현;

import java.util.HashMap;
import java.util.Scanner;

public class 대소문자_바꾸기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();

        HashMap<Character, Character> dics = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char a = (char) ('A' + i);
            char b = (char) ('a' + i);
            dics.put(a, b);
            dics.put(b, a);
        }

        for (char c : input) {
            System.out.print(dics.get(c));
        }
    }
}
