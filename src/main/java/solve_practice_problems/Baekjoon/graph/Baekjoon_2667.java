package solve_practice_problems.Baekjoon.graph;

import java.util.*;

public class Baekjoon_2667 {

    static boolean[][] visited;
    static int[][] table;
    static ArrayList<Integer> counts = new ArrayList<>();
    static int id = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        visited = new boolean[N][N];
        table = new int[N][N];

        for (int i = 0; i < table.length; i++) {
            String[] t = sc.nextLine().split("");
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = Integer.parseInt(t[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (table[i][j] == 0) continue;
                if (visited[i][j]) continue;
                ++id;
                count(i, j);
            }
        }

        System.out.println(id);
        counts.sort(Integer::compareTo);
        for (Integer count : counts)
            System.out.println(count);
    }

    static void count(int row, int col) {

        int count = 0;
        int n = table.length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            if (r < 0 || n - 1 < r) continue;
            if (c < 0 || n - 1 < c) continue;
            if (table[r][c] == 0) continue;
            if (visited[r][c]) continue;
            visited[r][c] = true;
            count++;

            q.offer(new int[]{r, c - 1});
            q.offer(new int[]{r, c + 1});
            q.offer(new int[]{r - 1, c});
            q.offer(new int[]{r + 1, c});
        }

        counts.add(count);
    }

}
