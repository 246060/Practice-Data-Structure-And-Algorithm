package algorithm.Basic.Two_Point;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_7795_먹을_것인가_먹힐_것인가 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] A = new int[N];
            int[] B = new int[M];

            for (int j = 0; j < A.length; j++) A[j] = sc.nextInt();
            for (int k = 0; k < B.length; k++) B[k] = sc.nextInt();

            Arrays.sort(A);
            Arrays.sort(B);

            int count = 0;
            for (int a : A) {
                for (int b : B) {
                    if (a <= b) break;
                    else count++;
                }
            }

            System.out.println(count);
        }
    }
}
