package algorithm.Graph.Flow_Network;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Priority_First_Search {
    // 에드몬드 카프 알고리즘
    // 현재 정점에서 연결된 간선의 용량이 최대인 값에 따라 DFS 와 BFS 대신 PFS를 이용하여 경로를 찾는 것이 Edmonds-Karp 방식이다.
    // 근데 여러 사이트에서 BFS 를 사용하면 에드몬드 카프 라고 한다.. 헷갈린다.
/*
6 10
0 1 14
0 3 18
1 2 15
1 3 12
2 4 9
2 5 6
3 1 6
3 4 16
4 1 11
4 5 28

4 5
0 1 100
0 2 100
1 2 1
2 3 100
1 3 100
---
[0, 3, 4, 5]
[0, 1, 2, 4, 5]
[0, 1, 2, 5]
[0, 3, 1, 2, 5]
31
실행 횟수: 4
--
[0, 1, 3]
[0, 2, 3]
200
실행 횟수: 2
*/
    static int[][] rn;
    static int max_flow, n;
    static boolean[] check;
    static ArrayList<Integer> path = new ArrayList<>();
    static int run_count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        rn = new int[n][n];
        check = new boolean[n];

        int m = sc.nextInt();

        while (m-- > 0) {
            rn[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }

        MaxFlow();
        System.out.println(max_flow);
        System.out.println("실행 횟수: " + run_count);
    }

    static boolean PFS(int x, int local_flow) {

        if (x == n - 1) {
            run_count++;
            max_flow += local_flow;
            System.out.println(path);

            for (int i = 0; i < path.size() - 1; i++) {
                rn[path.get(i)][path.get(i + 1)] -= local_flow;
                rn[path.get(i + 1)][path.get(i)] += local_flow;
            }

            path.clear();
            path.add(0);
            return true;
        }

        ArrayList<Vertex> v = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (rn[x][i] > 0 && check[i] == false) {
                Vertex vx = new Vertex();
                vx.idx = i;
                vx.weight = rn[x][i];
                v.add(vx);
            }
        }
        v.sort(Comparator.comparingInt(Vertex::getWeight).reversed());

        for (int i = 0; i < v.size(); i++) {
            Vertex vx = v.get(i);
            check[vx.idx] = true;
            path.add(vx.idx);

            if (PFS(vx.idx, Math.min(local_flow, vx.weight))) {
                return true;
            }

            path.remove(path.size() - 1);
            check[vx.idx] = false;
        }

        return false;
    }

    static void MaxFlow() {
        path.add(0);
        while (PFS(0, 999999999)) {
            Arrays.fill(check, false);
            check[0] = true;
        }
    }

    static class Vertex {
        int weight, idx;

        public int getWeight() {return weight;}

        public int getIdx() {return idx;}
    }

}
