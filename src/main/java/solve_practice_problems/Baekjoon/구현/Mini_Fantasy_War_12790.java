package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class Mini_Fantasy_War_12790 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int HP = sc.nextInt();
            int MP = sc.nextInt();
            int AT = sc.nextInt();
            int DE = sc.nextInt();

            int dhp = sc.nextInt();
            int dmp = sc.nextInt();
            int dat = sc.nextInt();
            int dde = sc.nextInt();

            HP += dhp;
            HP = HP < 1 ? 1 : HP;

            MP += dmp;
            MP = MP < 1 ? 1 : MP;

            AT += dat;
            AT = AT < 0 ? 0 : AT;

            DE += dde;

            System.out.println(1 * (HP) + 5 * (MP) + 2 * (AT) + 2 * (DE));
        }
    }
}
