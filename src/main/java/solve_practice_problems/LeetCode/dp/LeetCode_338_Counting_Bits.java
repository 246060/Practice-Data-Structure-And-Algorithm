package solve_practice_problems.LeetCode.dp;

import java.util.Arrays;

public class LeetCode_338_Counting_Bits {

    public static void main(String[] args) {
        int n = 0;

        n = 2;
        System.out.println(Arrays.toString(countBits(n)));

        n = 5;
        System.out.println(Arrays.toString(countBits(n)));
    }

    // dp  풀이 방식
    static public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int offset = 1;

        for (int i = 1; i < n + 1; i++) {
            if (offset * 2 == i) {
                offset = i;
            }
            dp[i] = 1 + dp[i - offset];
        }
        return dp;
    }

    static public int[] countBits2(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = getCnt(i);
        }
        return ans;
    }

    static int getCnt(int n) {
        int cnt = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                cnt++;
            }
            n /= 2;
        }
        return cnt;
    }
}
