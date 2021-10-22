package solve_practice_problems.LeetCode.dp;

public class LeetCode_96_Unique_Binary_Search_Trees {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(numTrees(n) == 5);

        n = 1;
        System.out.println(numTrees(n) == 1);
    }

    static public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }

        return dp[n];
    }
}
