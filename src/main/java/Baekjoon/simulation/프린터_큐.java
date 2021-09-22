package Baekjoon.simulation;

import java.util.*;

public class 프린터_큐 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int target = sc.nextInt();

            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            Queue<int[]> q = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                int priority = sc.nextInt();
                q.offer(new int[]{j, priority});
                pq.offer(priority);
            }

            int answer = 0;
            while (!pq.isEmpty()) {
                int bestPriority = pq.poll();

                while (true) {
                    int[] cur = q.peek();
                    int priority = cur[1];
                    if (bestPriority == priority) {
                        break;
                    } else {
                        q.offer(q.poll());
                    }
                }

                int[] cur = q.poll();
                int idx = cur[0];
                answer++;
                if (idx == target) {
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}
