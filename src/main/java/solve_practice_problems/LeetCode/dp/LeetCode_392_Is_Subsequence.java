package solve_practice_problems.LeetCode.dp;

public class LeetCode_392_Is_Subsequence {

    public static void main(String[] args) {

        String s;
        String t;

        s = "abc";
        t = "ahbgdc";
        System.out.println(isSubsequence(s, t) == true);

        s = "axc";
        t = "ahbgdc";
        System.out.println(isSubsequence(s, t) == false);
    }

    static public boolean isSubsequence(String s, String t) {

        char[] tArr = t.toCharArray();
        char[] sArr = s.toCharArray();
        int p = 0;

        if (sArr.length == 0) {
            return true;
        }

        if (tArr.length < sArr.length) {
            return false;
        }

        for (int i = 0; i < tArr.length; i++) {
            if (tArr[i] == sArr[p]) {
                p++;
                if (p == sArr.length) {
                    break;
                }
            }
        }

        return p == sArr.length;
    }
}
