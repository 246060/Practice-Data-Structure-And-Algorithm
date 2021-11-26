package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 관리자는_누구_14724 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] groups = {"PROBRAIN", "GROW", "ARGOS", "ADMIN", "ANT", "MOTION", "SPG", "COMON", "ALMIGHTY"};
        int n = sc.nextInt();

        int idx = 0;
        int finalMax = 0;

        for (int i = 0; i < 9; i++) {
            int max = 0;

            for (int j = 0; j < n; j++) {
                max = Math.max(max, sc.nextInt());
            }

            if (finalMax < max) {
                idx = i;
                finalMax = max;
            }
        }

        System.out.println(groups[idx]);
    }
}
