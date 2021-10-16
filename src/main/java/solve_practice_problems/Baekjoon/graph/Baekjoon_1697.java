package solve_practice_problems.Baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
이동하는 세 가지의 선택이 동시에 1초 씩 증가하므로 너비 우선 탐색을 선택

1. (현재 위치, 거기까지 걸린 초) 를 큐에 저장해서 사용
각 선택지가 이동하는 방법에 따라 시간이 다르므로, 이동하는 것에 따라 걸린 시간을 같이 보관했다.

2. 방문 체크가 필수이다.
방문했던 지점을 다시 밟는 것은 의미없는 것이다.
실컷 이동하다가 다시 같은 지점을 밟는 것은 결코 최소 거리가 될 수 없다. (+ 시간 초과 100%...)
*/

public class Baekjoon_1697 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        boolean[] visited = new boolean[100_000 + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{N, 0});

        int count = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int p = cur[0];
            int s = cur[1];

            if (0 > p || 100_000 < p) continue;
            if (visited[p]) continue;
            visited[p] = true;
            if (p == K) {
                count = s;
                break;
            }

            q.offer(new int[]{p + 1, s + 1});
            q.offer(new int[]{p - 1, s + 1});
            q.offer(new int[]{p * 2, s + 1});
        }

        System.out.println(count);
    }
}
