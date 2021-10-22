package solve_practice_problems.LeetCode.dp;

public class LeetCode_509_Fibonacci_Number {

    public static void main(String[] args) {
        int n = 0;
        n = 2;
        System.out.println(fib(n) == 1);

        n = 3;
        System.out.println(fib(n) == 2);

        n = 4;
        System.out.println(fib(n) == 3);
    }

    static public int fib(int n) {

        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
