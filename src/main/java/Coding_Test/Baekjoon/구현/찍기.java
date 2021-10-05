package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class 찍기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        char[] arr = sc.nextLine().toCharArray();

        String[] names = {"Adrian", "Bruno", "Goran"};
        String[] submits = new String[3];
        submits[0] = append("ABC", N);
        submits[1] = append("BABC", N);
        submits[2] = append("CCAABB", N);

        int[] scores = new int[3];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            char a = arr[i];
            for (int j = 0; j < 3; j++) {
                char b = submits[j].charAt(i);
                if (a == b) {
                    scores[j]++;
                    max = Math.max(max, scores[j]);
                }
            }
        }

        System.out.println(max);
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max)
                System.out.println(names[i]);
        }
    }

    static String append(String str, int n) {
        int len = str.length();
        String answer = str;
        if (len < n) {
            int a = n / len;
            while (a-- > 0) {
                answer += str;
            }
        }
        return answer;
    }
}
