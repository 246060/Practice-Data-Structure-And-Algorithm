package Coding_Test.NAVER.NAVER_FINANCIAL;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Problem2 {

    public static void main(String[] args) {

        int[][] arr = {
                {51, 71, 17, 42},
                {42, 33, 60},
                {51, 32, 43}
        };

        for (int i = 0; i < arr.length; i++) {
            System.out.println(solution(arr[i]));
        }
    }

    public static int solution(int[] A) {
        int ans = -1;

        HashMap<Integer, PriorityQueue<Integer>> bucket = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int cur = A[i];
            int sum = 0;
            while (cur != 0) {
                sum += cur % 10;
                cur /= 10;
            }

            if (bucket.containsKey(sum)) {
                bucket.get(sum).offer(A[i]);
            } else {
                PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
                pq.offer(A[i]);
                bucket.put(sum, pq);
            }
        }

        for (int key : bucket.keySet()) {
            int sum = -1;

            PriorityQueue<Integer> pq = bucket.get(key);
            if (pq.size() < 2) break;

            for (int i = 0; i < 2; i++) {
                if (sum == -1) sum = 0;
                sum += pq.poll();
            }

            ans = Math.max(ans, sum);
        }

        return ans;
    }

}
