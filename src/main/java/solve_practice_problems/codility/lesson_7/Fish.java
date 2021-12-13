package solve_practice_problems.codility.lesson_7;

import java.util.HashSet;
import java.util.Stack;

public class Fish {

    public static void main(String[] args) {

        int[] A = null;
        int[] B = null;

        A = new int[]{4, 3, 4, 2, 1, 5};
        B = new int[]{0, 1, 1, 0, 0, 0};

        System.out.println(solution(A, B));
    }

    public static int solution(int[] A, int[] B) {

        Stack<Integer> downSt = new Stack<>();
        int ans = 0;
        int last = 0;

        for (int i = 0; i < B.length; i++) {
            if (B[i] == 1) {
                downSt.push(A[i]);
            } else {

                while (!downSt.isEmpty()) {
                    last = downSt.peek();

                    if (last > A[i]) {
                        break;
                    } else {
                        downSt.pop();
                    }
                }

                if (downSt.isEmpty()) {
                    ans++;
                }
            }
        }

        return ans + downSt.size();
    }
}
