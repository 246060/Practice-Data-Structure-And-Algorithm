package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 알파벳_전부_쓰기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < N; i++) {
            char[] sentence = sc.nextLine().toLowerCase()
                                .replaceAll("[^a-z]", "")
                                .toCharArray();

            int[] arr = new int[26];
            for (int j = 0; j < sentence.length; j++) {
                int k = sentence[j] - 'a';
                if (0 <= k && k < 26) {
                    arr[k]++;
                }
            }

            boolean flag = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 0) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                System.out.print("missing ");
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == 0)
                        System.out.print((char) (j + 'a'));
                }
                System.out.println();
            } else {
                System.out.println("pangram");
            }
        }
    }
}
