package solve_practice_problems.Baekjoon.구현;

import java.util.HashSet;
import java.util.Scanner;

public class 대회_자리 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        for (int i = 0; i < K; i++) {
            HashSet<Integer> set = new HashSet<>();
            int P = sc.nextInt();
            int M = sc.nextInt();
            for (int j = 0; j < P; j++) {
                set.add(sc.nextInt());
            }
            System.out.println(P - set.size());
        }
    }
}
