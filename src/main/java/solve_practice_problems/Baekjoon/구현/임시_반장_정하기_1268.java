package solve_practice_problems.Baekjoon.구현;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class 임시_반장_정하기_1268 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] map = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        HashMap<Integer, HashSet<Integer>> hmap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hmap.put(i, new HashSet<>());
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == k) continue;
                    if (map[j][i] == map[k][i]) {
                        hmap.get(j).add(k);
                    }
                }
            }
        }

        int idx = 0;
        int max = Integer.MIN_VALUE;

        for (int key : hmap.keySet()) {
            int size = hmap.get(key).size();
            if (max < size) {
                idx = key;
                max = size;
            } else if (max == size && idx > key) {
                idx = key;
            }
        }

        System.out.println(idx + 1);
    }
}
