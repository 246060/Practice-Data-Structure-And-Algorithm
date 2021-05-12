package algorithm.Array;

import java.util.Arrays;

public class Example_Prefix_Sum {
    // 구간합 - 접두사 합 예제

    public static void main(String[] args) {
        // P[right] - P[left-1]

        int n = 5;
        int[] a = {10, 20, 30, 40, 50};

        int[] P = new int[n + 1];
        for (int i = 0; i < n; i++)
            P[i + 1] = a[i] + P[i];

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(P));

        System.out.format("1 ~ 3 구간 합 : %d\n", P[3] - P[1 - 1]);
        System.out.format("2 ~ 5 구간 합 : %d\n", P[5] - P[2 - 1]);
        System.out.format("3 ~ 4 구간 합 : %d\n", P[4] - P[3 - 1]);
    }

}
