package solve_practice_problems.Baekjoon.구현;

import java.util.ArrayList;
import java.util.Scanner;

public class 중복을_없애자 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            int idx = 0;
            ArrayList<Integer> answer = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int k = sc.nextInt();
                if (idx == 0) {
                    answer.add(k);
                    idx++;
                } else {
                    if (answer.get(idx - 1) != k) {
                        answer.add(k);
                        idx++;
                    }
                }
            }

            for (int val : answer) {
                System.out.print(val + " ");
            }
            System.out.println("$");
        }
    }
}
