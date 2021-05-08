package algorithm.Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon_10974 {
// 모든 순열

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++)
            arr[i] = i;

        backtracking(1, arr, new ArrayList<>());
    }

    static void backtracking(int level, int[] arr, ArrayList<Integer> result) {
        if (arr.length - 1 == result.size()) {
            for (int o : result)
                System.out.print(o + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            if (result.contains(arr[i])) {
                continue;
            }
            result.add(arr[i]);
            backtracking(i + 1, arr, result);
            result.remove(result.size() - 1);
        }
    }
}
