package Coding_Test.Baekjoon.구현;

import java.util.HashSet;
import java.util.Scanner;

public class 아름다운_수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            HashSet<Integer> set = new HashSet<>();
            int num = sc.nextInt();
            while (num > 0) {
                set.add(num % 10);
                num /= 10;
            }
            System.out.println(set.size());
        }
    }
}
