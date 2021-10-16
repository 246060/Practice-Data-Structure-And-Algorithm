package solve_practice_problems.Baekjoon.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 정수 1 : 익은 토마토
// 정수 0 : 익지 않은 토마토
// 정수 -1 : 토마토 없는 칸

//  저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,
//  토마토가 모두 익지는 못하는 상황이면 -1을 출력

public class Baekjoon_7576 {

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); // 가로
        int N = sc.nextInt();
        int[][] table = new int[N][M];

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                table[i][j] = sc.nextInt();
                if (table[i][j] == 1) queue.offer(new int[]{i, j});
                if (table[i][j] == 0) count++;
            }
        }

        if (count == 0) {
            System.out.println(0);
            return;
        }

        // BFS 로 해결해야된다.
        int days = 0;
        while (true) {
            if (queue.isEmpty()) break;
            days++;

            ArrayList<int[]> list = new ArrayList<>(queue);
            queue.clear();
            for (int[] point : list) {
                count = growUp(table, point[0], point[1], count);
            }
        }

        if (count != 0) {
            System.out.println(-1);
        } else {
            System.out.println(days - 1);
        }
    }

    static int growUp(int[][] table, int r, int c, int count) {
        if (isValid(table, r, c - 1)) {
            queue.offer(new int[]{r, c - 1});
            table[r][c - 1] = 1;
            --count;
        }
        if (isValid(table, r, c + 1)) {
            queue.offer(new int[]{r, c + 1});
            table[r][c + 1] = 1;
            --count;
        }
        if (isValid(table, r - 1, c)) {
            queue.offer(new int[]{r - 1, c});
            table[r - 1][c] = 1;
            --count;
        }
        if (isValid(table, r + 1, c)) {
            queue.offer(new int[]{r + 1, c});
            table[r + 1][c] = 1;
            --count;
        }

        return count;
    }

    static boolean isValid(int[][] table, int r, int c) {
        if (r < 0 || c < 0)
            return false;
        if (r > table.length - 1 || c > table[0].length - 1)
            return false;
        if (table[r][c] == 1 || table[r][c] == -1)
            return false;
        return true;
    }
}
