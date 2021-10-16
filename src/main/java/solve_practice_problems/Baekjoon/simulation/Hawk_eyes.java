package solve_practice_problems.Baekjoon.simulation;

import java.util.HashMap;
import java.util.Scanner;

public class Hawk_eyes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] orders = sc.nextLine().split("");

        int[] cups = new int[4];
        cups[0] = 1;
        cups[3] = 2;

        HashMap<String, int[]> rules = new HashMap<>();
        rules.put("A", new int[]{0, 1});
        rules.put("B", new int[]{0, 2});
        rules.put("C", new int[]{0, 3});
        rules.put("D", new int[]{1, 2});
        rules.put("E", new int[]{1, 3});
        rules.put("F", new int[]{2, 3});

        for (String order : orders) {
            int[] cur = rules.get(order);
            swap(cups, cur[0], cur[1]);
        }

        int smallIdx = 0;
        int largeIdx = 0;
        for (int i = 0; i < cups.length; i++) {
            if (cups[i] == 1) {
                smallIdx = i;
            } else if (cups[i] == 2) {
                largeIdx = i;
            }
        }

        System.out.println(smallIdx + 1);
        System.out.println(largeIdx + 1);
    }

    static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
