package solve_practice_problems.Baekjoon.구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 럭비_클럽_2083 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> result = new ArrayList<>();
        while (true) {
            String[] input = sc.nextLine().split(" ");
            if (input[0].equals("#")) {
                return;
            }

            String tmp = input[0];
            int age = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            if (18 <= age || 80 <= weight) {
                tmp += " Senior";
            } else {
                tmp += " Junior";
            }

            System.out.println(tmp);
        }
    }
}
