package solve_practice_problems.Baekjoon.구현;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 콘테스트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> wpq = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue).reversed());
        PriorityQueue<Integer> kpq = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue).reversed());

        for (int i = 0; i < 20; i++) {
            if (i < 10) {
                wpq.offer(sc.nextInt());
            } else {
                kpq.offer(sc.nextInt());
            }
        }

        int w = 0, k = 0;
        for (int i = 0; i < 3; i++) w += wpq.poll();
        for (int i = 0; i < 3; i++) k += kpq.poll();
        System.out.println(w + " " + k);
    }
}
