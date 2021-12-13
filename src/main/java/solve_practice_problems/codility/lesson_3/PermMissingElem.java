package solve_practice_problems.codility.lesson_3;

public class PermMissingElem {

    public static void main(String[] args) {

        int[] A = null;

        A = new int[]{2, 3, 1, 5};
        System.out.println(solution(A));


        A = new int[]{2, 3, 1, 5};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {

        int n = A.length;
        int[] marks = new int[n + 2];

        for (int i = 0; i < A.length; i++) {
            marks[A[i]] = 1;
        }

        int result = 0;
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] == 0) {
                result = i;
                break;
            }
        }

        return result;
    }
}
