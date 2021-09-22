package algorithm.Number_Theory;

import java.util.ArrayList;

public class PowerSet {

    //  부분집합 구하는 방법
    // 1. 조합
    // 2. 재귀
    // 3. 비트마스크

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        int n = 3;
        boolean[] visited = new boolean[n];

        powerSet(arr, visited, n, 0);
        bit(arr, n);

        ArrayList<ArrayList<Integer>> powersets = bit2(arr, n);
        for (ArrayList<Integer> powerset : powersets) {
            System.out.println(powerset);
        }
    }

    static void powerSet(int[] arr, boolean[] visited, int n, int idx) {
        if (idx == n) {
            print(arr, visited, n);
            return;
        }

        visited[idx] = false;
        powerSet(arr, visited, n, idx + 1);

        visited[idx] = true;
        powerSet(arr, visited, n, idx + 1);
    }

/*
    # 비트를 이용한 구현

    n 이 3이라고 할 때 1 << n 은 1000(2) 입니다.
    첫번째 for 문에서 i 는 1 << n 전까지 증가하니까 111(2) 까지 증가합니다.
    즉 i 는
        000
        001
        010
        011
        100
        101
        110
        111
    이렇게 증가합니다.
    한번 쓱 보니 비트 자체만으로도 부분 집합이 형성되었습니다.

    j 를 통해서
        001
        010
        100
    위 숫자들과 AND 연산을 통해서 1 인 비트들을 인덱스처럼 사용할 수 있습니다.
*/

    static void bit(int[] arr, int n) {

        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0)
                    System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }

    static ArrayList<ArrayList<Integer>> bit2(int[] arr, int n) {
        ArrayList<ArrayList<Integer>> powersets = new ArrayList<>();

        for (int i = 0; i < 1 << n; i++) {
            ArrayList<Integer> powerset = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0)
                    powerset.add(arr[j]);
            }

            powersets.add(powerset);
        }
        return powersets;
    }

    static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
