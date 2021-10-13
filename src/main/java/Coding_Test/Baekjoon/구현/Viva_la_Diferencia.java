package Coding_Test.Baekjoon.구현;

import java.util.Scanner;

public class Viva_la_Diferencia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            if (a == 0 && b == 0 && c == 0 && d == 0) {
                break;
            }

            int cnt = 0;
            boolean flag = a == b && b == c && c == d && d == a;
            while (!flag) {
                cnt++;
                int ta = a, tb = b, tc = c, td = d;
                a = Math.abs(ta - tb);
                b = Math.abs(tb - tc);
                c = Math.abs(tc - td);
                d = Math.abs(td - ta);

                flag = a == b && b == c && c == d && d == a;
            }

            System.out.println(cnt);
        }
    }
}
