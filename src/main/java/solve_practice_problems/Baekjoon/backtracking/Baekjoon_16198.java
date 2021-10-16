package solve_practice_problems.Baekjoon.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_16198 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//        int N = 4;
//        int[] W = {1, 2, 3, 4};

        int N = sc.nextInt();
        sc.nextLine();
        int[] W = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        visited = new boolean[N];
        backtracking(0, W, 0);
        System.out.println(answer);
    }

    static boolean[] visited;
    static int answer = 0;

    static void backtracking(int level, int[] W, int sum) {

        if (level == W.length - 2) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 1; i < W.length - 1; i++) {
            if (!visited[i]) {

                int left = i - 1;
                int right = i + 1;

                // 방문하지 않은 왼쪽을 찾는다.
                while (visited[left] && left > 0) left--;

                // 방문하지 않은 오른쪽을 찾는다.
                while (visited[right] && right < W.length - 1) right++;

                visited[i] = true;
                backtracking(level + 1, W, sum + (W[left] * W[right]));
                visited[i] = false;
            }
        }
    }
}
