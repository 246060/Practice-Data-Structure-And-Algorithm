package solve_practice_problems.Baekjoon.구현;

import java.util.LinkedList;
import java.util.Scanner;

public class 줄_세우기_2605 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int jump = sc.nextInt();
            list.add(list.size() - jump, i + 1);
        }

        for (int v : list) {
            System.out.print(v + " ");
        }
    }
}
