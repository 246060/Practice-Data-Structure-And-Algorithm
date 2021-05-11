package algorithm.Graph.Strongly_Connected_Component;

import java.util.ArrayList;
import java.util.Stack;

public class Tarjan {

    public static void main(String[] args) {

        int V = 11;
        isFinished = new boolean[V + 1];
        d = new int[V + 1];

        for (int i = 0; i <= V; i++)
            a.add(new ArrayList<>());

        a.get(1).add(2);
        a.get(2).add(3);
        a.get(3).add(1);
        a.get(4).add(2);
        a.get(4).add(5);
        a.get(5).add(7);
        a.get(6).add(5);
        a.get(7).add(6);
        a.get(8).add(5);
        a.get(8).add(9);
        a.get(9).add(10);
        a.get(10).add(11);
        a.get(11).add(3);
        a.get(11).add(8);

        for (int i = 1; i <= V; i++)
            if (d[i] == 0)
                dfs(i);

        // SCC의 갯수: 4
        // 1번째 SCC : [1, 2, 3]
        // 2번째 SCC : [5, 6, 7]
        // 3번째 SCC : [4]
        // 4번째 SCC : [8, 9, 10, 11]
        System.out.format("SCC의 갯수: %d\n", SCC.size());
        for (int i = 0; i < SCC.size(); i++) {
            System.out.format("%d번째 SCC : ", i + 1);
            System.out.println(SCC.get(i).stream().sorted().toList());
        }
    }

    static int id;
    static int[] d;
    static boolean[] isFinished;
    static ArrayList<ArrayList<Integer>> a = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> SCC = new ArrayList<>();
    static Stack<Integer> stack = new Stack<>();

    static int dfs(int x) {

        d[x] = ++id;   // 노드마다 고유한 번호를 할당
        stack.push(x); // 스택을 자기 자신을 삽입

        int parent = d[x];

        for (int y : a.get(x))
            if (d[y] == 0)
                parent = Math.min(parent, dfs(y));
            else if (!isFinished[y])
                parent = Math.min(parent, d[y]);

        if (parent == d[x]) {
            // 부모노드가 자기 자신인 경우
            ArrayList<Integer> scc = new ArrayList<>();
            while (true) {
                int t = stack.pop();
                scc.add(t);
                isFinished[t] = true;
                if (t == x) break;
            }
            SCC.add(scc);
        }

        return parent;
    }
}
