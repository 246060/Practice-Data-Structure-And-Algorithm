package algorithm.Graph.Topological_Sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_1005_ACM_Craft {
//    위상 정렬
//    다이나믹 프로그래밍

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt(); // 건물 개수
            int K = sc.nextInt(); // 건설순서규칙의 총 개수

            int[] inDegrees = new int[N + 1]; // 각 건물의 진입 차수
            int[] result = new int[N + 1];

            int[] buildTimes = new int[N + 1]; // 각 건물당 건설에 걸리는 시간
            for (int j = 1; j < N + 1; j++)
                buildTimes[j] = sc.nextInt();

            ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
            for (int j = 0; j <= N; j++)
                nodes.add(new ArrayList<>());

            for (int j = 0; j < K; j++) { // 건설순서 X -> Y
                int cur = sc.nextInt();
                int adjacent = sc.nextInt();
                nodes.get(cur).add(adjacent);
                inDegrees[adjacent]++;
            }

            // 승리하기 위해 건설해야 할 건물의 번호
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
                    // 이미 계산된 값과 새롭게 들어오는 노드의 값을 비교하여 큰 값
                    result[adjacent] = Math.max(result[adjacent], result[cur] + buildTimes[adjacent]);
                    inDegrees[adjacent]--;

                    if (inDegrees[adjacent] == 0)
                        q.offer(adjacent);
                }
            }

            System.out.println(result[target]);
        }
    }
}
