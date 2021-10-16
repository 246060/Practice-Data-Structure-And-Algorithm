package solve_practice_problems.Baekjoon.구현;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 유니크 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] map = new int[N][3];
        int r = map.length;
        int c = map[0].length;

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                map[i][j] = sc.nextInt();

        int[] sums = new int[N];

        for (int i = 0; i < c; i++) {
            HashMap<Integer, ArrayList<Integer>> dics = new HashMap<>();

            for (int j = 0; j < r; j++) {
                if (dics.containsKey(map[j][i])) {
                    dics.get(map[j][i]).add(j);
                } else {
                    ArrayList<Integer> t = new ArrayList<>();
                    t.add(j);
                    dics.put(map[j][i], t);
                }
            }

            for (int key : dics.keySet())
                if (dics.get(key).size() <= 1)
                    sums[dics.get(key).get(0)] += key;
        }

        for (int i = 0; i < N; i++)
            System.out.println(sums[i]);
    }
}
