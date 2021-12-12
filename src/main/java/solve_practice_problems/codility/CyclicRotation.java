package solve_practice_problems.codility;

import java.util.Arrays;

public class CyclicRotation {

    public static void main(String[] args) {

        int[] A = null;
        int K = 0;

        A = new int[]{1, 2, 3, 4};
        K = 4;

        System.out.println(Arrays.toString(solution(A, K)));


        A = new int[]{3, 8, 9, 7, 6};
        K = 3;

        System.out.println(Arrays.toString(solution(A, K)));


    }

    public static int[] solution(int[] A, int K) {
        // write your code in Java SE 11

        int n = A.length;
        int[] result = new int[n];

        for (int i = 0; i < A.length; i++) {
            result[(i + K) % n] = A[i];
        }

        return result;
    }

}
