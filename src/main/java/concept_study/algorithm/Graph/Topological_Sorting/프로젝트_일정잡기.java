package concept_study.algorithm.Graph.Topological_Sorting;

import java.util.*;

public class 프로젝트_일정잡기 {
    /*
2
A 5
B 3 A
D 2 A
C 2 B
F 2 CE
E 4 DC

A 5
B 3 A
D 2 A
C 2 B
F 2 CE
E 4 DC
0 0
    */
    static int[] inDegrees;
    static int[] weights, sums;
    static boolean[][] graph;
    static char[] alpha;
    static HashMap<Character, Integer> alphaIdx = new HashMap<>();
    static int n, max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            ArrayList<String> lines = new ArrayList<>();
            while (true) {
                String line = sc.nextLine();
                if (line.isEmpty()) break;
                if (line.equals("0 0")) break;
                lines.add(line);
            }

            n = lines.size();
            max = 0;
            inDegrees = new int[n];
            weights = new int[n];
            graph = new boolean[n][n];
            alpha = new char[n];
            sums = new int[n];

            for (int j = 0; j < lines.size(); j++) {
                String[] split = lines.get(j).split(" ");
                char v = split[0].charAt(0);
                int w = Integer.parseInt(split[1]);
                alphaIdx.put(v, j);
                weights[j] = w;
            }

            for (String line : lines) {
                String[] split = line.split(" ");
                if (split.length < 3) continue;

                int to = alphaIdx.get(split[0].charAt(0));

                split = split[2].split("");
                for (int j = 0; j < split.length; j++) {
                    int from = alphaIdx.get(split[j].charAt(0));
                    graph[from][to] = true;
                    inDegrees[to]++;
                }
            }

            TS();
            System.out.println(max);
        }
    }

    static void TS() {
        int i, j, k = n;

        while (k-- > 0) {
            for (i = 0; i < n; i++) {
                if (inDegrees[i] == 0) break;
            }
            inDegrees[i]--;

            sums[i] = Math.max(weights[i], sums[i]);
            max = Math.max(max, sums[i]);

            for (j = 0; j < n; j++) {
                if (graph[i][j]) {
                    inDegrees[j]--;

                    // 이전 작업의 최대 시간과 현재 작업시간을 더한 시간하고
                    // 이전에 구해진 시간 합중 더 긴 시간을 저장한다.
                    sums[j] = Math.max(sums[j], sums[i] + weights[j]);
                }
            }
        }
    }
}
