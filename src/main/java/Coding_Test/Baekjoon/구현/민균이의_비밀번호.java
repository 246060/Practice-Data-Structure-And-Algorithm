package Coding_Test.Baekjoon.구현;

import java.util.HashSet;
import java.util.Scanner;

public class 민균이의_비밀번호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            if (str.equals(new StringBuilder(str).reverse().toString())) {
                int len = str.length();
                System.out.println(len + " " + str.charAt(len / 2));
                break;
            }

            if (set.contains(new StringBuilder(str).reverse().toString())) {
                int len = str.length();
                System.out.println(len + " " + str.charAt(len / 2));
                break;
            } else {
                set.add(str);
            }
        }
    }
}
