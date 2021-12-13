package solve_practice_problems.codility.lesson_4;

import java.util.Arrays;

public class MaxCounters {

    public static void main(String[] args) {

        int N = 0;
        int[] A = null;

        N = 5;
        A = new int[]{3, 4, 4, 6, 1, 4, 4};
        System.out.println(Arrays.toString(solution(N, A))); // 3, 2, 2, 4, 2


        N = 1;
        A = new int[]{2, 1, 1, 2, 1};
        System.out.println(Arrays.toString(solution(N, A))); // 3
    }

    public static int[] solution(int N, int[] A) {
        int[] ans = new int[N];

        int max = 0;
        int tmp = 0;

        for (int i = 0; i < A.length; i++) {

            if (N + 1 == A[i]) {
                max += tmp;
                tmp = 0;

            } else {

                if (ans[A[i] - 1] < max) {
                    ans[A[i] - 1] = max;
                }

                ans[A[i] - 1]++;

                if (ans[A[i] - 1] > tmp + max) {
                    tmp = ans[A[i] - 1] - max;
                }
            }
        }

        for (int i = 0; i < ans.length; i++) {
            if (ans[i] < max) {
                ans[i] = max;
            }
        }

        return ans;
    }

}
