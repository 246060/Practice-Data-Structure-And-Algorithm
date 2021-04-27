package algorithm.Dynamic_Programming;

import java.util.Scanner;

public class Baekjoon_2839_Sugar_Delivery {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        System.out.println(fun(N));
    }

    private static int fun(int N) {

        int[] a = new int[Math.max(N, 5) + 1];
        a[0] = 0;
        a[1] = -1;
        a[2] = -1;
        a[3] = 1;
        a[4] = -1;
        a[5] = 1;

        for (int i = 6; i <= N; i++) {
            int f3 = a[i - 3];
            int f5 = a[i - 5];

            if (a[i - 3] == -1 && a[i - 5] == -1)
                a[i] = -1;
            else if (a[i - 3] == -1)
                a[i] = f5 + 1;
            else if (a[i - 5] == -1)
                a[i] = f3 + 1;
            else
                a[i] = Math.min(f3, f5) + 1;
        }

        return a[N];
    }

}
