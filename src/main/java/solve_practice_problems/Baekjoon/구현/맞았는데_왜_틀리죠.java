package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 맞았는데_왜_틀리죠 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s1 = sc.nextInt();
        int s2 = sc.nextInt();

        for (int i = 0; i < s1; i++) {
            int t = sc.nextInt();
            int a = sc.nextInt();
            if (t != a) {
                System.out.println("Wrong Answer");
                return;
            }
        }

        for (int i = 0; i < s2; i++) {
            int t = sc.nextInt();
            int a = sc.nextInt();
            if (t != a) {
                System.out.println("Why Wrong!!!");
                return;
            }
        }

        System.out.println("Accepted");
    }
}
