package concept_study.algorithm.Graph.Union_Find;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 친구들 {
/*
2
3 2
1 2
2 3
10 12
1 2
3 1
3 4
5 4
3 5
4 6
5 2
2 1
7 10
1 2
9 10
8 9
*/

    static int[] un, nums;
    static int N, max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            N = sc.nextInt();
            int M = sc.nextInt();

            un = new int[N + 1];
            nums = new int[N + 1];
            Arrays.fill(nums, 1);

            makeSet();
            while (M-- > 0) {
                union(sc.nextInt(), sc.nextInt());
            }

            System.out.println(max);
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a > b) {
                un[a] = b;
                nums[b] += nums[a];
                max = Math.max(max, nums[b]);
            } else {
                un[b] = a;
                nums[a] += nums[b];
                max = Math.max(max, nums[a]);
            }
        }
    }

    static int find(int x) {
        Queue<Integer> q = new LinkedList<>();

        while (x != un[x]) {
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
        for (int i = 1; i <= N; i++) {
            un[i] = i;
        }
    }
}
