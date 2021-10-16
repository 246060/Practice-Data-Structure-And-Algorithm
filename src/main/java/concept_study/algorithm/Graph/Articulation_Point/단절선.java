package concept_study.algorithm.Graph.Articulation_Point;

import java.util.ArrayList;
import java.util.Scanner;

public class 단절선 {
    // https://ip99202.github.io/posts/%EB%8B%A8%EC%A0%88%EC%84%A0-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/
    /*
     * 단절점과 다른 점
     * 1. 부모 정점은 발견 시간 갱신 대상이 아님
     * 2. x > check[s] 조건에 '=' 제외
     * 3. 루트 노드의 단절선을 자식의 수로 판별하지 않음.
     * */
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] check;
    static int cnt, total;
    static ArrayList<int[]> cb = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        for (int i = 0; i <= V; i++)
            graph.add(new ArrayList<>());

        check = new int[V + 1];

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1, 0);

        cb.sort((o1, o2) -> {
            int compare = Integer.compare(o1[0], o2[0]);
            return compare != 0 ? compare : Integer.compare(o1[1], o2[1]);
        });

        System.out.println(total);
        for (int[] pair : cb)
            System.out.println(pair[0] + " " + pair[1]);
    }

    static int dfs(int s, int p) {
        check[s] = ++cnt;
        int mn = cnt;

        for (int i : graph.get(s)) {
            // 부모와 연결선은 제외
            if (i == p) continue;

            if (check[i] == 0) {
                int x = dfs(i, s);
                mn = Math.min(mn, x);

                // 자식이 갈수 있는 조상과 현재 노드의 비교
                if (x > check[s]) {
                    total++;
                    cb.add(new int[]{Math.min(s, i), Math.max(s, i)});
                }
            } else {
                mn = Math.min(mn, check[i]);
            }
        }

        return mn;
    }
}
