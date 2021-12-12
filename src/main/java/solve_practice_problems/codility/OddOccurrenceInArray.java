package solve_practice_problems.codility;

import java.util.HashSet;

public class OddOccurrenceInArray {

    public static void main(String[] args) {

        int[] A = null;

        A = new int[]{9, 3, 9, 3, 9, 9, 7};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (set.contains(A[i])) {
                set.remove(A[i]);
            } else {
                set.add(A[i]);
            }
        }

        int result = 0;
        for (int element : set) {
            result = element;
            break;
        }

        return result;
    }
}
