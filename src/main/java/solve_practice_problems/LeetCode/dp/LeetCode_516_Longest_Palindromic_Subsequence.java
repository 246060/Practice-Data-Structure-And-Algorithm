package solve_practice_problems.LeetCode.dp;

public class LeetCode_516_Longest_Palindromic_Subsequence {
    public static void main(String[] args) {

        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s) == 4);

        s = "cbbd";
        System.out.println(longestPalindromeSubseq(s) == 2);
    }

    static public int longestPalindromeSubseq(String s) {

        int n = s.length();
        int i = n;
        for (; i > 0; i--) {

        }

        return 0;
    }


    static boolean recursive(){
        return false;
    }
}
