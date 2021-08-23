package algorithm.Two_Point;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon_16472_고냥이 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        char[] arr = sc.nextLine().toCharArray();

        int e = 0, count = 0, max = Integer.MIN_VALUE;
        LinkedList<Character> list = new LinkedList<>();

        while (true) {
            if (e >= arr.length) break;

            if (count < N) {
                list.add(arr[e++]);
                count++;
            } else {
                if (list.contains(arr[e])) {
                    list.add(arr[e++]);
                } else {
                    list.add(arr[e++]);
                    count++;
                    HashSet<Character> set = new HashSet<>();
                    do {
                        list.removeFirst();
                        set.clear();
                        set.addAll(list);
                        count = set.size();
                    } while (count > N);
                }
            }

            max = Math.max(max, list.size());
        }

        System.out.println(max);
    }
}
