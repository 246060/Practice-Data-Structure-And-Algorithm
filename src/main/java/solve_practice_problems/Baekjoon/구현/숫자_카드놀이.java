package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 숫자_카드놀이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int num = sc.nextInt();
            if (num == 0) break;

            while (num > 9) {
                System.out.print(num + " ");

                int a = num;
                int b = 1;
                while (a > 0) {
                    b *= a % 10;
                    a /= 10;
                }

                num = b;
            }

            System.out.println(num);
        }
    }
}
