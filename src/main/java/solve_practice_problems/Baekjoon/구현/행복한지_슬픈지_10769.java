package solve_practice_problems.Baekjoon.구현;

import java.util.HashSet;
import java.util.Scanner;

public class 행복한지_슬픈지_10769 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        HashSet<Integer> happySet = new HashSet<>();
        HashSet<Integer> sadSet = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            int idx1 = input.indexOf(":-)", i);
            int idx2 = input.indexOf(":-(", i);
            if (idx1 != -1) {
                happySet.add(idx1);
            }
            if (idx2 != -1) {
                sadSet.add(idx2);
            }
        }

        if (happySet.size() == 0 && sadSet.size() == 0) {
            System.out.println("none");
        } else if (happySet.size() > sadSet.size()) {
            System.out.println("happy");
        } else if (happySet.size() < sadSet.size()) {
            System.out.println("sad");
        } else {
            System.out.println("unsure");
        }
    }
}
