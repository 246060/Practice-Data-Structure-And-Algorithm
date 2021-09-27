package algorithm.Basic.Greedy;

import java.util.*;

// 그리디 대표 문제
// 최소로 필요한 강의실 수
public class Baekjoon_11000 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<int[]> durations = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            durations.add(new int[]{sc.nextInt(), sc.nextInt()});
        }

        durations.sort((o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(durations.get(0)[1]);

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < durations.size(); i++) {

            while (!pq.isEmpty() && pq.peek() <= durations.get(i)[0]) {
                pq.poll();
            }
            pq.offer(durations.get(i)[1]);
            ans = Math.max(ans, pq.size());
        }

        System.out.println(ans);
    }
}
