package algorithm.Backtracking;

import java.util.Arrays;

public class Permutation {

    public static void main(String[] args) {

        String[] a = {"a", "b", "c"};
        permutations(0, a, new String[3]);
    }

    static boolean[] visited = new boolean[3];

    static void permutations(int level, String[] arr, String[] result) {

        if (level == arr.length) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[level] = arr[i];
                permutations(level + 1, arr, result);
                visited[i] = false;
            }
        }
    }
}
