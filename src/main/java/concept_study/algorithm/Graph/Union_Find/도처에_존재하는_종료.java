package concept_study.algorithm.Graph.Union_Find;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 도처에_존재하는_종료 {
/*
10 9
1 2
1 3
1 4
1 5
1 6
1 7
1 8
1 9
1 10
10 4
2 3
3 4
3 8
4 8
0 0
*/

    static int[] un;
    static int n, uc;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int order = 0;
        while (true) {
            n = sc.nextInt();
            uc = n;
            int m = sc.nextInt();

            if (n == 0 & m == 0) {
                return;
            }

            un = new int[n + 1];
            makeSet();

            while (m-- > 0) {
                union(sc.nextInt(), sc.nextInt());
            }

            System.out.println("Case " + ++order + ": " + uc);
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a > b) {
                un[a] = b;
            } else {
                un[b] = a;
            }
            --uc;
        }
    }

    static int find(int x) {
        Queue<Integer> q = new LinkedList<>();

        while (un[x] != x) {
            if (un[x] != un[un[x]]) {
                q.offer(x);
            }
            x = un[x];
        }

        while (!q.isEmpty()) {
            un[q.poll()] = x;
        }

        return x;
    }

    static void makeSet() {
        for (int i = 1; i <= n; i++) {
            un[i] = i;
        }
    }
}
