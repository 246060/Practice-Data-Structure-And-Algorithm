package algorithm.Backtracking;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baekjoon_6603 {
// 로또

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>();
        while (true) {
            String t = sc.nextLine();
            if (t.length() == 1) break;
            inputs.add(t);
        }

        for (String input : inputs) {
            StringTokenizer st = new StringTokenizer(input);
            int k = Integer.parseInt(st.nextToken());

            int[] lotto = new int[k];
            for (int i = 0; i < k; i++)
                lotto[i] = Integer.parseInt(st.nextToken());

            backtracking(0, lotto, new ArrayList<>());
            System.out.println();
        }
    }

    static void backtracking(int level, int[] lotto, ArrayList<Integer> answer) {
        if (6 == answer.size()) {
            for (int o : answer) {
                System.out.print(o + " ");
            }
            System.out.println();
            return;
        }

        for (int i = level; i < lotto.length; i++) {
            answer.add(lotto[i]);
            backtracking(i + 1, lotto, answer);
            answer.remove(answer.size() - 1);
        }
    }
}
