package solve_practice_problems.Baekjoon.traversal;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class 트리의_부모_찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer>[] tree = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            tree[s].add(e);
            tree[e].add(s);
        }

        int root = 1;
        int[] parents = new int[n + 1];
        parents[root] = -1;
        buildParent(tree, root, parents);

        for (int i = 2; i < n + 1; i++) {
            System.out.println(parents[i]);
        }
    }

    static void buildParent(ArrayList<Integer>[] tree, int root, int[] parents) {
        Stack<int[]> st = new Stack<>();
        st.push(new int[]{root, parents[root]});

        while (!st.isEmpty()) {
            int cur = st.peek()[0];
            int parent = st.peek()[1];
            st.pop();

            for (int child : tree[cur]) {
                if (child == parent) continue;
                st.push(new int[]{child, cur});
                parents[child] = cur;
            }
        }
    }
}
