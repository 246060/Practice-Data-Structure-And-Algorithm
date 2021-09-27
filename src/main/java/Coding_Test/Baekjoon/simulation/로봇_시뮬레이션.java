package Coding_Test.Baekjoon.simulation;

import java.util.Scanner;

public class 로봇_시뮬레이션 {

    final static String WALL_CRASH_MESSAGE = "Robot %d crashes into the wall";
    final static String ROBOT_CRASH_MESSAGE = "Robot %d crashes into robot %d";

    static final int NORTH = 0;
    static final int EAST = 1;
    static final int SOUTH = 2;
    static final int WEST = 3;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        int[][] map = new int[B][A];
        int[] directions = new int[N + 1];

        for (int i = 0; i < N; i++) {
            String[] split = sc.nextLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);

            map[B - y][x - 1] = i + 1;
            directions[i + 1] = change(split[2].charAt(0));
        }

        for (int i = 0; i < M; i++) {
            String[] split = sc.nextLine().split(" ");
            int robotId = Integer.parseInt(split[0]);
            char op = split[1].charAt(0);
            int iter = Integer.parseInt(split[2]);

            for (int j = 0; j < iter; j++) {
                int d = directions[robotId];

                switch (op) {
                    case 'L': directions[robotId] = d - 1 < 0 ? 3 : --d; break;
                    case 'R': directions[robotId] = d + 1 > 3 ? 0 : ++d; break;
                    case 'F':

                        int[] cur = getPoint(map, robotId);
                        int y = cur[0] + dy[d];
                        int x = cur[1] + dx[d];

                        if (x < 0 || y < 0 || x > A - 1 || y > B - 1) {
                            System.out.println(String.format(WALL_CRASH_MESSAGE, robotId));
                            return;
                        }

                        if (map[y][x] != 0) {
                            System.out.println(String.format(ROBOT_CRASH_MESSAGE, robotId, map[y][x]));
                            return;
                        }

                        map[cur[0]][cur[1]] = 0;
                        map[y][x] = robotId;
                        break;

                    default:
                        break;
                }
            }
        }

        System.out.println("OK");
    }

    static int[] getPoint(int[][] map, int robotId) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == robotId) return new int[]{i, j};
            }
        }
        return null;
    }

    static int change(char d) {
        switch (d) {
            case 'N': return NORTH;
            case 'E': return EAST;
            case 'S': return SOUTH;
            case 'W': return WEST;
        }
        return 0;
    }
}
