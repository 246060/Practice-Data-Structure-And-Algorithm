package Coding_Test.Baekjoon.구현;

import java.util.Arrays;
import java.util.Scanner;

public class 단어_퍼즐 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = 0;
        while (true) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();

            if (str1.equals("END") && str2.equals("END")) {
                break;
            }

            char[] arr1 = str1.toCharArray();
            char[] arr2 = str2.toCharArray();

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            str1 = String.valueOf(arr1);
            str2 = String.valueOf(arr2);

            i++;
            if (str1.equals(str2)) {
                System.out.println(String.format("Case %d: same", i));
            } else {
                System.out.println(String.format("Case %d: different", i));
            }
        }
    }
}
