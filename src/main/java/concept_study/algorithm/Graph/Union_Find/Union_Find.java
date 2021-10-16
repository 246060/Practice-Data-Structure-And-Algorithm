package concept_study.algorithm.Graph.Union_Find;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Union_Find {
    /* input

    6 4
    3 2
    1 3
    5 4
    3 5

    */
    static int[] un;
    static int n, uc;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();

        un = new int[n + 1];
        uc = n;

        makeSet();

        while (m-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b);
        }

        System.out.println("집합 개수 : " + uc);
        union_print();
    }

    static void union_print() {
        boolean[] visit = new boolean[n + 1];

        while (uc-- > 0) { // 루프 한 번 당 하나의 집합들이 출력
            int i;
            for (i = 1; i <= n; i++)
                if (!visit[i]) break;

            int a = i;

            for (i = 1; i <= n; i++) {
                if (!visit[i] && a == find(i)) {
                    System.out.print(i + " ");
                    visit[i] = true;
                }
            }

            System.out.println();
        }
    }

    static void union(int a, int b) {
        int p = find(a);
        int q = find(b);

        if (p != q) {
            if (p > q) {
                un[p] = q;
            } else {
                un[q] = p;
            }
            --uc;
        }
    }

    static void makeSet() {
        for (int i = 1; i <= n; i++) {
            un[i] = i;
        }
    }

    static int find(int x) {
        Queue<Integer> q = new LinkedList<>();

        while (un[x] != x) {
            if (un[x] != un[un[x]])
                q.offer(x);

            x = un[x];
        }

        while (!q.isEmpty()) {
            un[q.poll()] = x;
        }

        return x;
    }
}
