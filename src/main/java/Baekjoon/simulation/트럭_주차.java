package Baekjoon.simulation;

import java.util.*;

public class 트럭_주차 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int[] arr = new int[101];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            q.offer(new int[]{s, e});
            for (int j = s; j < e; j++) {
                arr[j] += 1;
            }
        }

        int totalCost = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int s = cur[0];
            int e = cur[1];

            int cost = 0;
            for (int i = s; i < e; i++) {
                if (arr[i] == 1) {
                    cost += A;
                } else if (arr[i] == 2) {
                    cost += B;
                } else if (arr[i] >= 3) {
                    cost += C;
                }
            }

            totalCost += cost;
        }

        System.out.println(totalCost);
    }
}
