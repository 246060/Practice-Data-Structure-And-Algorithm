package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 화성_수학 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            String[] input = sc.nextLine().split(" ");

            double num = Double.parseDouble(input[0]);
            for (int j = 1; j < input.length; j++)
                num = calc(num, input[j]);

            System.out.println(String.format("%.2f", num));
        }

    }

    static double calc(double num, String s) {
        if (s.equals("@")) {
            return num * 3;
        } else if (s.equals("%")) {
            return num + 5;
        } else { // #
            return num - 7;
        }
    }
}
