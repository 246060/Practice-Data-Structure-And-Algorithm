package solve_practice_problems.codility.lesson_4;

import java.util.Arrays;

public class PermCheck {

    public static void main(String[] args) {

        int[] A = null;

//        A = new int[]{4, 1, 3};
//        System.out.println(solution(A));
//
//        A = new int[]{4, 1, 3, 2};
//        System.out.println(solution(A));

        A = new int[]{1, 1};
        System.out.println(solution(A)); // 0

        A = new int[]{2};
        System.out.println(solution(A)); // 0

        A = new int[]{1};
        System.out.println(solution(A)); // 1
    }

    public static int solution(int[] A) {
        Arrays.sort(A);

        int n = A.length;
        for (int i = 0, j = 1; i < n; i++, j++) {
            if (A[i] != j) {
                return 0;
            }
        }

        return 1;
    }
}
