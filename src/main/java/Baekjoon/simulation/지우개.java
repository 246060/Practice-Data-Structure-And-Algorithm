package Baekjoon.simulation;

import java.util.LinkedList;
import java.util.Scanner;

public class 지우개 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            list1.add(i + 1);
        }

        int idx = 1;
        while (true) {
            if (list1.size() == 1) break;

            list2.add(list1.get(idx));
            idx += 2;

            if (idx > N - 1) {
                idx = 1;
                list1 = list2;
                list2 = new LinkedList<>();
                N = list1.size();
            }
        }

        System.out.println(list1.get(0));
    }
}
