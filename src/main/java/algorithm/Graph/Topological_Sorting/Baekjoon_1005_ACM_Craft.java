package algorithm.Graph.Topological_Sorting;

import java.util.*;

public class Baekjoon_1005_ACM_Craft {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            int[] inDegrees = new int[N + 1];
            int[] result = new int[N + 1];

            int[] buildTimes = new int[N + 1];
            for (int j = 1; j < N + 1; j++)
                buildTimes[j] = sc.nextInt();

            ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
            for (int j = 0; j <= N; j++)
                nodes.add(new ArrayList<>());

            for (int j = 0; j < K; j++) {
                int cur = sc.nextInt();
                int adjacent = sc.nextInt();
                nodes.get(cur).add(adjacent);
                inDegrees[adjacent]++;
            }

            int target = sc.nextInt();

            Queue<Integer> q = new LinkedList<>();
            for (int j = 1; j < N + 1; j++) {
                if (inDegrees[j] == 0) {
                    result[j] = buildTimes[j];
                    q.offer(j);
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int adjacent : nodes.get(cur)) {
                    result[adjacent] = Math.max(result[adjacent], result[cur] + buildTimes[adjacent]);
                    if (--inDegrees[adjacent] == 0)
                        q.offer(adjacent);
                }
            }

            System.out.println(result[target]);
        }
    }
}
