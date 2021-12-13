package solve_practice_problems.codility.lesson_3;

import java.util.Arrays;

public class TapeEquilibrium {

    public static void main(String[] args) {

        int[] A = null;

        A = new int[]{3, 1, 2, 4, 3};
        System.out.println(solution(A));

        A = new int[]{-1000, 1000};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int sum = Arrays.stream(A).sum();

        int min = Integer.MAX_VALUE;
        int leftSum = 0;
        int rightSum = sum;

        for (int i = 0; i < A.length - 1; i++) {
            leftSum += A[i];
            rightSum -= A[i];
            min = Math.min(min, Math.abs(leftSum - rightSum));
        }

        return min;
    }
}
