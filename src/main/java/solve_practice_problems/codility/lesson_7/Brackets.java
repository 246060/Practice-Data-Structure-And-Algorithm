package solve_practice_problems.codility.lesson_7;

import java.util.Stack;

public class Brackets {

    public static void main(String[] args) {

        String S = null;

//        S = "{[()()]}";
//        System.out.println(solution(S)); // 1
//
//        S = "([)()]";
//        System.out.println(solution(S)); // 0

        S = ")(";
        System.out.println(solution(S)); // 0
    }

    public static int solution(String S) {

        char[] arr = S.toCharArray();

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            char cur = arr[i];

            if (cur == '{' || cur == '[' || cur == '(') {
                st.push(cur);

            } else {
                if (cur == '}') {
                    if (st.isEmpty() || st.peek() != '{') {
                        return 0;
                    } else {
                        st.pop();
                    }
                } else if (cur == ']') {
                    if (st.isEmpty() || st.peek() != '[') {
                        return 0;
                    } else {
                        st.pop();
                    }
                } else {
                    if (st.isEmpty() || st.peek() != '(') {
                        return 0;
                    } else {
                        st.pop();
                    }
                }
            }
        }

        return st.size() > 0 ? 0 : 1;
    }
}