package algorithm.Graph.Topological_Sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_2252_Line_up {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
        int[] inDegree = new int[n + 1];

        for (int i = 0; i <= n; i++)
            nodes.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int cur = sc.nextInt();
            int adjacent = sc.nextInt();
            nodes.get(cur).add(adjacent);
            inDegree[adjacent]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
                System.out.print(i + " ");
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int node : nodes.get(cur)) {
                inDegree[node]--;
                if (inDegree[node] == 0) {
                    q.add(node);
                    System.out.print(node + " ");
                }
            }
        }

    }
}
