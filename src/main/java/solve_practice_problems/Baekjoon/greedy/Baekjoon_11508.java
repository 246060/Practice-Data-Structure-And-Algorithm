package solve_practice_problems.Baekjoon.greedy;

import java.util.*;

public class Baekjoon_11508 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] milks = new int[N];
        for (int i = 0; i < N; i++)
            milks[i] = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int milk : milks)
            pq.offer(milk);

        ArrayList<Integer> box = new ArrayList<>(3);
        int sum = 0;
        while (!pq.isEmpty()) {
            int milk = pq.poll();
            box.add(milk);

            if (box.size() == 3) {
                box.clear();
            }else{
                sum += milk;
            }
        }

        System.out.println(sum);
    }
}
