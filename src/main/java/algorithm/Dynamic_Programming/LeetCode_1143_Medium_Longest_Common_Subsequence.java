package algorithm.Dynamic_Programming;

public class LeetCode_1143_Medium_Longest_Common_Subsequence {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String text1_1 = "abcde";
        String text1_2 = "ace";
        // expected output = 3
        System.out.println(solution.longestCommonSubsequence(text1_1, text1_2) == 3);

        String text2_1 = "abc";
        String text2_2 = "abc";
        // expected output = 3
        System.out.println(solution.longestCommonSubsequence(text2_1, text2_2) == 3);

        String text3_1 = "abc";
        String text3_2 = "def";
        // expected output = 0
        System.out.println(solution.longestCommonSubsequence(text3_1, text3_2) == 0);
    }


    private static class Solution {

        // dp(m,n) = if text1[m] == text2[n]
        //             dp(m-1,n-1)+1
        //           else
        //             max(dp(m-1,n), dp(m, n-1))

        public int longestCommonSubsequence(String text1, String text2) {

            text1 = "@" + text1;
            text2 = "@" + text2;

            int m = text1.length();
            int n = text2.length();

            int[][] matrix = new int[m][n];

            for (int r = 1; r < matrix.length; r++) {
                for (int c = 1; c < matrix[r].length; c++) {
                    if (text1.charAt(r) == text2.charAt(c))
                        matrix[r][c] = matrix[r - 1][c - 1] + 1;
                    else
                        matrix[r][c] = Math.max(matrix[r - 1][c], matrix[r][c - 1]);
                }
            }

            int rLast = matrix.length - 1;
            int cLast = matrix[rLast].length - 1;

            return matrix[rLast][cLast];
        }
    }
}
