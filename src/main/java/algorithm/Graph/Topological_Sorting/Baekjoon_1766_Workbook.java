package algorithm.Graph.Topological_Sorting;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon_1766_Workbook {
// 한글 문제명 : 문제집

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] inDegrees = new int[N + 1];

        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i < N + 1; i++)
            nodes.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            int cur = sc.nextInt();
            int adjacent = sc.nextInt();
            nodes.get(cur).add(adjacent);
            inDegrees[adjacent]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i < N + 1; i++)
            if (inDegrees[i] == 0)
                q.offer(i);

        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");

            for (int adjacent : nodes.get(cur))
                if (--inDegrees[adjacent] == 0)
                    q.offer(adjacent);
        }
    }
}
