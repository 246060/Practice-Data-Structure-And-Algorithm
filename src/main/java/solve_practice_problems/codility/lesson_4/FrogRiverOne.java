package solve_practice_problems.codility.lesson_4;

import java.util.HashSet;

public class FrogRiverOne {
    public static void main(String[] args) {

        int X = 0;
        int[] A = null;

        X = 5;
        A = new int[]{1, 3, 1, 4, 2, 3, 5, 4};
        System.out.println(solution(X, A));
    }

    public static int solution(int X, int[] A) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= X; i++) {
            set.add(i);
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (set.contains(A[i])) {
                set.remove(A[i]);
            }

            if (set.isEmpty()) {
                ans = i;
                break;
            }
        }

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}
