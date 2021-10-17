package concept_study.algorithm.mathematics;

import java.util.Arrays;
import java.util.LinkedList;

public class Permutation2 {

    public static void main(String[] args) {

        String[] a = {"a", "b", "c"};
        permutations(0, a, new String[3]);


        int n = 3;                                  // 3가지 숫자 중
        int r = 2;                                  // 2개를 뽑을 경우
        int[] input = {1, 2, 3};                      // 주어진 3가지 숫자
        int[] answer = new int[r];                  // 정답을 담을 배열
        boolean[] check = new boolean[n];           // 해당 숫자를 방문했는지 체크

        // 순열
        permutation(n, r, input, check, answer, 0);
        // 중복순열
        // permutationDup(n, r, input, answer, 0);
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

     static void permutation(int n, int r, int[] input, boolean[] check, int[] answer, int depth) {
        if (depth == r) {
            print(answer);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                check[i] = true; // 중복 체크
                answer[depth] = input[i];
                permutation(n, r, input, check, answer, depth + 1);
                check[i] = false;
            }
        }
    }

     static void permutationDup(int n, int r, int[] input, int[] answer, int depth) {
        if (depth == r) {
            print(answer);
            return;
        }

        for (int i = 0; i < n; i++) {
            answer[depth] = input[i];
            permutationDup(n, r, input, answer, depth + 1);
        }
    }

     static void print(int[] answer) {
        for (Integer ans : answer) {
            System.out.print(ans + " ");
        }
        System.out.println();
    }


    static boolean nextPermutation(int[] list) {
        int i = list.length - 1;
        int j = list.length - 1;

        /** 1. 꼭대기 찾기 **/
        while (i > 0 && list[i - 1] >= list[i]) --i;
        if (i <= 0) return false;    // 꼭대기가 0번째 인덱스라면 마지막순열

        /** 2. j값 찾기 **/
        while (list[i - 1] > list[j]) --j;
        swap(i - 1, j);

        /** 3. 순서 정해주기 **/
        j = list.length - 1;
        for (; i < j; ++i, --j) {
            swap(i, j);
        }
        return true;
    }

    static void swap(int i, int j) {
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void Permutation(int n, int r, LinkedList<Integer> perArr, int[] Check) {
        if (perArr.size() == r) {
            for (int i = 0; i < perArr.size(); i++) System.out.print(i + " ");
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (Check[i] == 0) {
                perArr.add(i);
                Check[i] = 1;
                Permutation(n, r, perArr, Check);
                Check[i] = 0;
                perArr.removeLast();
            }
        }
    }
}
