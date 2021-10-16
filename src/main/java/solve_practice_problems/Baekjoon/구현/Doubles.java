package solve_practice_problems.Baekjoon.구현;

import java.util.HashSet;
import java.util.Scanner;

public class Doubles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int num = sc.nextInt();
            if (num == -1) break;

            HashSet<Integer> set = new HashSet<>();
            set.add(num);

            while (true) {
                num = sc.nextInt();
                if (num == 0) {
                    break;
                }
                set.add(num);
            }

            int cnt = 0;
            for (int v : set) {
                if (set.contains(v * 2)) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
