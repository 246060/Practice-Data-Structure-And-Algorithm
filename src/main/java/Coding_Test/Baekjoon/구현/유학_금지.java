package Coding_Test.Baekjoon.구현;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class 유학_금지 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] filter_chars = "CAMBRIDGE".split("");
        HashSet<String> filter = new HashSet<>();
        for (int i = 0; i < filter_chars.length; i++) {
            filter.add(filter_chars[i]);
        }

        String word = sc.nextLine();
        for (String alphabet : filter) {
            word = word.replaceAll(alphabet, "");
        }

        System.out.println(word);
    }
}
