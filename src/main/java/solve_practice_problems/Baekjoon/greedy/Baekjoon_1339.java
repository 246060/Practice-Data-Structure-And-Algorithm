package solve_practice_problems.Baekjoon.greedy;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon_1339 {

    static class Char {
        String s;
        int sum;
        int x;

        public Char(String s, int sum) {
            this.s = s;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = sc.nextLine();
        }

        HashMap<String, Integer> sums = new HashMap<>();

        for (String word : words) {
            String[] cur = word.split("");
            for (int i = 0; i < cur.length; i++) {
                int exp = cur.length - (1 + i);
                if (sums.containsKey(cur[i])) {
                    sums.put(cur[i], sums.get(cur[i]) + (int) Math.pow(10, exp));
                } else {
                    sums.put(cur[i], (int) Math.pow(10, exp));
                }
            }
        }

        PriorityQueue<Char> pq = new PriorityQueue<>((o1, o2) -> o2.sum - o1.sum);
        for (String key : sums.keySet())
            pq.offer(new Char(key, sums.get(key)));

        int answer = 0;
        int i = 9;
        while (!pq.isEmpty()) {
            answer += pq.poll().sum * i--;
        }

        System.out.println(answer);
    }
}
