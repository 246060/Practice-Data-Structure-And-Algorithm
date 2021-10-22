package solve_practice_problems.LeetCode.dp;

public class LeetCode_1025_Divisor_Game {

    public static void main(String[] args) {

        int n = 2;
        System.out.println(divisorGame(n) == true);

        n = 3;
        System.out.println(divisorGame(n) == false);

        n = 5;
        System.out.println(divisorGame(n) == false);
    }

    static public boolean divisorGame(int n) {
        return backtrack(n, new Boolean[n + 1]);
    }

    static boolean backtrack(int n, Boolean[] memo) {
        if (n <= 1) {
            return false;
        }

        if (memo[n] != null) {
            return memo[n];
        }

        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                if (!backtrack(n - i, memo)) {
                    memo[n] = true;
                    return true;
                }
            }
        }

        memo[n] = false;
        return false;
    }
}
