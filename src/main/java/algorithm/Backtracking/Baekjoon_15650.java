package algorithm.Backtracking;

import java.util.ArrayList;

public class Baekjoon_15650 {

    static int[] arr;
    static int N;
    static int M;

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        N = sc.nextInt();
//        M = sc.nextInt();

        N = 4;
        M = 2;

        arr = new int[N + 1];
        for (int i = 1; i < arr.length; i++)
            arr[i] = i;

        backtracking(1, new ArrayList<>());
    }

    static void backtracking(int level, ArrayList<Integer> result) {
        if (result.size() == M) {
            StringBuilder sb = new StringBuilder();
            for (int o : result)
                sb.append(o).append(" ");

            System.out.println(sb);
            return;
        }

        for (int i = level; i < arr.length; i++) {
            if (result.contains(i))
                continue;

            result.add(i);
            backtracking(i + 1, result);
            result.remove(result.size() - 1);
        }
    }
}
