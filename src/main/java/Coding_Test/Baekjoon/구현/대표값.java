package Coding_Test.Baekjoon.구현;

import java.util.*;

public class 대표값 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int cur = sc.nextInt();
            list.add(cur);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }

        int avg = (int) list.stream().mapToInt(Integer::intValue).average().getAsDouble();

        int maxK = 0, maxCnt = Integer.MIN_VALUE;
        for (int k : map.keySet()) {
            int cnt = map.get(k);
            if (maxCnt < cnt) {
                maxK = k;
                maxCnt = cnt;
            }
        }

        System.out.println(avg);
        System.out.println(maxK);
    }
}
