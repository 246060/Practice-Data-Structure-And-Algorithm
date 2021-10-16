package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 팬들에게_둘러싸인_홍준 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String id = sc.nextLine();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    System.out.print(":" + id + ":");
                } else {
                    System.out.print(":fan:");
                }
            }
            System.out.println();
        }
    }
}
