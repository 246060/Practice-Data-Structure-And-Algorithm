package solve_practice_problems.Baekjoon.backtracking;

import java.util.*;

public class Baekjoon_15663 {

    static int[] arr;
    static int N;
    static int M;
    static LinkedHashSet<String> ans = new LinkedHashSet<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N + 1];
        for (int i = 1; i < arr.length; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);
        backtracking(new ArrayList<>());

        ans.forEach(System.out::println);
    }

    static void backtracking(ArrayList<Integer> result) {
        if (result.size() == M) {
            StringBuilder sb = new StringBuilder();
            for (int o : result)
                sb.append(arr[o]).append(" ");
            ans.add(sb.toString());
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            if (result.contains(i))
                continue;

            result.add(i);
            backtracking(result);
            result.remove(result.size() - 1);
        }
    }
}
