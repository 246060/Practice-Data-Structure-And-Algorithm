package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 문자열_분석 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            char[] str = sc.nextLine().toCharArray();
            int[] counts = new int[4];

            for (char c : str) {
                if (Character.isLowerCase(c)) {
                    counts[0]++;
                } else if (Character.isUpperCase(c)) {
                    counts[1]++;
                } else if (Character.isDigit(c)) {
                    counts[2]++;
                } else {
                    counts[3]++;
                }
            }

            for (int count : counts) {
                System.out.print(count + " ");
            }
            System.out.println();
        }
    }
}
