package concept_study.algorithm.simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_14891 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] gears = new String[5];

        for (int i = 1; i < gears.length; i++)
            gears[i] = sc.nextLine();

        int N = sc.nextInt();
        int[][] requests = new int[N][2];

        for (int[] startPoint : requests) {
            startPoint[0] = sc.nextInt();
            startPoint[1] = sc.nextInt();
        }

        for (int[] request : requests) {
            int[] dirs = new int[4 + 1];
            decideDirection(gears, dirs, request);
            rotate(gears, dirs);
        }

        int ans = getResult(gears);
        System.out.println(ans);
    }

    static void decideDirection(String[] gears, int[] dirs, int[] startPoint) {
        int startIndex = startPoint[0];
        int startDirection = startPoint[1];
        dirs[startIndex] = startDirection;

        Queue<Integer> q = new LinkedList<>();
        boolean[] rotation = new boolean[4 + 1];
        q.offer(startIndex);
        rotation[startIndex] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur < 4) {
                if (gears[cur].charAt(2) != gears[cur + 1].charAt(6)) {
                    if (!rotation[cur + 1]) {
                        rotation[cur + 1] = true;

                        if (dirs[cur] == 1) dirs[cur + 1] = -1;
                        else dirs[cur + 1] = 1;

                        q.offer(cur + 1);
                    }
                }
            }

            if (cur > 1 && !rotation[cur - 1]) {
                if (gears[cur - 1].charAt(2) != gears[cur].charAt(6)) {
                    if (!rotation[cur - 1]) {
                        rotation[cur - 1] = true;

                        if (dirs[cur] == 1) dirs[cur - 1] = -1;
                        else dirs[cur - 1] = 1;

                        q.offer(cur - 1);
                    }
                }
            }
        }
    }

    static void rotate(String[] gears, int[] dirs) {
        // 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향
        for (int i = 1; i < dirs.length; i++) {
            if (dirs[i] == 1) {
                gears[i] = toRight(gears[i]);
            } else if (dirs[i] == -1) {
                gears[i] = toLeft(gears[i]);
            }
        }
    }

    static int getResult(String[] gears) {
        int ans = 0;
        for (int i = 1; i < gears.length; i++) {
            if (gears[i].charAt(0) == '1') {
                ans += Math.pow(2, i - 1);
            }
        }
        return ans;
    }

    static String toLeft(String s) {
        int last = s.length() - 1;
        String firstChar = String.valueOf(s.charAt(0));
        String result = s.substring(1, last + 1) + firstChar;
        return result;
    }

    static String toRight(String s) {
        int last = s.length() - 1;
        String lastChar = String.valueOf(s.charAt(last));
        String result = lastChar + s.substring(0, last);
        return result;
    }

}
