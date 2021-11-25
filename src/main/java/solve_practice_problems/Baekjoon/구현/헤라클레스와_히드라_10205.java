package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 헤라클레스와_히드라_10205 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        for (int i = 0; i < K; i++) {
            int h = sc.nextInt();
            sc.nextLine();

            char[] orders = sc.nextLine().toCharArray();

            for (int j = 0; j < orders.length; j++) {
                if (orders[j] == 'c') {
                    h++;
                } else {
                    h--;
                    if (h == 0) {
                        break;
                    }
                }
            }
            System.out.println(String.format("Data Set %d:", (i + 1)));
            System.out.println(h);
            System.out.println();
        }

    }
}
