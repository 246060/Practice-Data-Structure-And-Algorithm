package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 개표 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        sc.nextLine();

        char[] votes = sc.nextLine().toCharArray();
        int A = 0, B = 0;
        for (int i = 0; i < V; i++) {
            if (votes[i] == 'A') {
                A++;
            } else {
                B++;
            }
        }

        if (A > B) {
            System.out.println("A");
        } else if (A < B) {
            System.out.println("B");
        } else {
            System.out.println("Tie");
        }
    }
}
