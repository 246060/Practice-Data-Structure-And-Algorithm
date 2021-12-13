package solve_practice_problems.codility.lesson_7;

import java.util.Stack;

public class Nesting {

    public static void main(String[] args) {

        String S;

        S = "(()(())())";
        System.out.println(solution(S));

        S = "())";
        System.out.println(solution(S));
    }

    public static int solution(String S) {

        char[] arr = S.toCharArray();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            char cur = arr[i];

            if (cur == '(') {
                st.push(cur);
            } else {
                if (st.isEmpty()) {
                    return 0;
                }
                st.pop();
            }
        }

        return st.size() > 0 ? 0 : 1;
    }
}
