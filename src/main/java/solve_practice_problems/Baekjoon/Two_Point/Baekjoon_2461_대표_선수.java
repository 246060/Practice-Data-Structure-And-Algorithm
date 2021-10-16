package solve_practice_problems.Baekjoon.Two_Point;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon_2461_대표_선수 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), M = sc.nextInt();
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
            Arrays.sort(arr[i]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] idxs = new int[N];
        while (true) {
            int min = Integer.MAX_VALUE, min_row = 0, min_idx = 0;
            int max = Integer.MIN_VALUE;

            // 모든 학생의 능력치는 다르다.!!!
            for (int i = 0; i < N; i++) {
                if (min > arr[i][idxs[i]]) {
                    min = arr[i][idxs[i]];
                    min_row = i;
                    min_idx = idxs[i];
                }
                if (max < arr[i][idxs[i]]) {
                    max = arr[i][idxs[i]];
                }
            }

            pq.offer(max - min);
            if ((idxs[min_row] = min_idx + 1) >= M) {
                break;
            }
        }

        System.out.println(pq.poll());
    }
}
