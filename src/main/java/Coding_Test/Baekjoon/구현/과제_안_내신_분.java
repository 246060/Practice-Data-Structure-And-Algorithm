package Coding_Test.Baekjoon.구현;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class 과제_안_내신_분 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= 30; i++) {
            set.add(i);
        }

        for (int i = 0; i < 28; i++) {
            set.remove(sc.nextInt());
        }
        ArrayList<Integer> answer = new ArrayList<>(set);
        answer.sort(Integer::compareTo);

        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }
}
