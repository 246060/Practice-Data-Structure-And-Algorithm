package solve_practice_problems.LeetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_22_Medium_Generate_Parentheses {

    public static void main(String[] args) {

        int n = 3;
        // return : ["((()))","(()())","(())()","()(())","()()()"]
        System.out.println(generateParenthesis(n));

        n = 1;
        // return : ["()"]
        System.out.println(generateParenthesis(n));
    }

    static ArrayList<String> list = new ArrayList<>();

    static public List<String> generateParenthesis(int n) {
        list.clear();
        backtracking(n, 0, 0, "");
        return list;
    }

    static void backtracking(int n, int open, int close, String result) {
        if (n * 2 == result.length()) {
            list.add(result);
            return;
        }
        if (open < n) backtracking(n, open + 1, close, result + "(");
        if (close < open) backtracking(n, open, close + 1, result + ")");
    }
}
