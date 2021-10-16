package solve_practice_problems.Baekjoon.구현;

import java.util.HashMap;
import java.util.Scanner;

public class 개수_세기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = -100; i <= 100; i++) {
            map.put(i, 0);
        }

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }

        System.out.println(map.get(sc.nextInt()));
    }
}
