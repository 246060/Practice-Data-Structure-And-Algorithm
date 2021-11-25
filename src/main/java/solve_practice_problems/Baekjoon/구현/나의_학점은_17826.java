package solve_practice_problems.Baekjoon.구현;

import java.util.Arrays;
import java.util.Scanner;

public class 나의_학점은_17826 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] scores = new int[50];
        for (int i = 0; i < 50; i++) {
            scores[i] = sc.nextInt();
        }

        int t = sc.nextInt();
        Arrays.sort(scores);
        int index = Arrays.binarySearch(scores, t);
        index = 50 - index;

        if (1 <= index && index <= 5) {
            System.out.println("A+");
        } else if (6 <= index && index <= 15) {
            System.out.println("A0");
        } else if (16 <= index && index <= 30) {
            System.out.println("B+");
        } else if (31 <= index && index <= 35) {
            System.out.println("B0");
        } else if (36 <= index && index <= 45) {
            System.out.println("C+");
        } else if (46 <= index && index <= 48) {
            System.out.println("C0");
        } else {
            System.out.println("F");
        }
    }
}
