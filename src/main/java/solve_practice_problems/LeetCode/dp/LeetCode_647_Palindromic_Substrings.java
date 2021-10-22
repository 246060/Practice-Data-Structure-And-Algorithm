package solve_practice_problems.LeetCode.dp;

public class LeetCode_647_Palindromic_Substrings {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(countSubstrings(s) == 3);

        s = "aaa";
        System.out.println(countSubstrings(s) == 6);
    }

    static public int countSubstrings(String s) {
        int cnt = 0;

        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            cnt++;
        }

        for (int t = 1; t < n; t++) {
            for (int h = 0; h < t; h++) {

                if (t - h == 1) {
                    if (s.charAt(t) == s.charAt(h)) {
                        dp[h][t] = 2;
                        cnt++;
                    }
                }else{
                    int in = dp[h + 1][t - 1];
                    if (in != 0) {
                        if (s.charAt(t) == s.charAt(t - in - 1)) {
                            dp[h][t] = 2 + in;
                            cnt++;
                        }
                    }
                }
            }
        }

        return cnt;
    }
}
