package solve_practice_problems.Baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_7562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int L = sc.nextInt();
            int[] source = new int[]{sc.nextInt(), sc.nextInt()};
            int[] dest = new int[]{sc.nextInt(), sc.nextInt()};

            int count = 0;
            boolean[][] visited = new boolean[L][L];
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{source[0], source[1], 0});

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                int s = cur[2];

                if (c < 0 || L - 1 < c) continue;
                if (r < 0 || L - 1 < r) continue;
                if (visited[r][c]) continue;
                visited[r][c] = true;

                if (r == dest[0] && c == dest[1]) {
                    count = s;
                    break;
                }

                q.offer(new int[]{r + 2, c + 1, s + 1});
                q.offer(new int[]{r + 1, c + 2, s + 1});
                q.offer(new int[]{r - 1, c + 2, s + 1});
                q.offer(new int[]{r - 2, c + 1, s + 1});
                q.offer(new int[]{r - 2, c - 1, s + 1});
                q.offer(new int[]{r - 1, c - 2, s + 1});
                q.offer(new int[]{r + 1, c - 2, s + 1});
                q.offer(new int[]{r + 2, c - 1, s + 1});
            }

            System.out.println(count);
        }

    }
}
