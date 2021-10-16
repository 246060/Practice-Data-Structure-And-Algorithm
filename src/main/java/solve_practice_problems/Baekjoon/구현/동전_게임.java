package solve_practice_problems.Baekjoon.구현;

import java.util.HashMap;
import java.util.Scanner;

public class 동전_게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < P; i++) {
            char[] game = sc.nextLine().toCharArray();

            HashMap<String, Integer> disc = new HashMap<>();
            disc.put("TTT", 0);
            disc.put("TTH", 1);
            disc.put("THT", 2);
            disc.put("THH", 3);
            disc.put("HTT", 4);
            disc.put("HTH", 5);
            disc.put("HHT", 6);
            disc.put("HHH", 7);

            int n = game.length;
            int[] answer = new int[8];
            char[] arr = new char[3];

            for (int l = 0, r = 2; r < n; l++, r++) {
                for (int j = l, k = 0; j <= r; k++, j++) {
                    arr[k] = game[j];
                }
                answer[disc.get(String.valueOf(arr))]++;
            }

            for (int j = 0; j < answer.length; j++) {
                System.out.print(answer[j] + " ");
            }
            System.out.println();
        }
    }
}
