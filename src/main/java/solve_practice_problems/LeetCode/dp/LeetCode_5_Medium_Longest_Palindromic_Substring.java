package solve_practice_problems.LeetCode.dp;

public class LeetCode_5_Medium_Longest_Palindromic_Substring {

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s1 = "babad";
        // expected output = bab or "aba" is also a valid answer.
        System.out.println(solution.longestPalindrome(s1).equals("bab"));

        String s2 = "cbbd";
        // expected output = bb
        System.out.println(solution.longestPalindrome(s2).equals("bb"));

        String s3 = "a";
        // expected output = a
        System.out.println(solution.longestPalindrome(s3).equals("a"));

        String s4 = "ac";
        // expected output = a
        System.out.println(solution.longestPalindrome(s4).equals("a"));

        String s5 = "aaaaa";
        // expected output = aaaaa
        System.out.println(solution.longestPalindrome(s5).equals("aaaaa"));
    }

    private static class Solution {
        // problem = 2 + sub-problem

        public String longestPalindrome(String s) {

            int[][] memo = new int[s.length()][s.length()];
            int n = memo.length;

            // init
            for (int from = 0; from < n; from++) {
                for (int to = from; to < from + 2 && to < n; to++) {
                    if (from == to)
                        memo[from][to] = 1;
                    else
                        memo[from][to] = s.charAt(from) == s.charAt(to) ? 2 : 0;
                }
            }

            for (int col = 2; col < memo.length; col++) {
                for (int row = 0; row < col; row++) {

                    if (memo[row + 1][col - 1] == 0)
                        continue;

                    int preCol = col - memo[row + 1][col - 1] - 1;

                    if (s.charAt(col) == s.charAt(preCol)) {
                        // problem = 2 + sub-problem
                        memo[row][col] = 2 + memo[row + 1][col - 1];
                    }
                }
            }

            int max = 0, from = 0, to = 0;
            for (int i = 0; i < memo.length; i++) {
                for (int j = i; j < memo[i].length; j++) {
                    if (max < memo[i][j]) {
                        max = memo[i][j];
                        from = i;
                        to = j;
                    }
                }
            }

            return s.substring(from, to + 1);
        }
    }
}