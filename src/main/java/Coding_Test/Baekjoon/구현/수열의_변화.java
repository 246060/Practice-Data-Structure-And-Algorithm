package Coding_Test.Baekjoon.구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 수열의_변화 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        List<Integer> list = new ArrayList<>();
        String[] split = sc.nextLine().split(",");
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }

        while (K-- > 0) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 1; i < list.size(); i++) {
                tmp.add(list.get(i) - list.get(i - 1));
            }
            list = tmp;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + ",");
        }
        System.out.print(list.get(list.size() - 1));

    }
}
