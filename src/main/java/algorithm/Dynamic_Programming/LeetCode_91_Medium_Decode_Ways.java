package algorithm.Dynamic_Programming;

import java.util.HashMap;

public class LeetCode_91_Medium_Decode_Ways {

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s1 = "12"; // 12
        // expected output = 2
        System.out.println(solution.numDecodings(s1) == 2);

        String s2 = "226";
        // expected output = 3
        System.out.println(solution.numDecodings(s2) == 3);

        String s3 = "0";
        // expected output = 0
        System.out.println(solution.numDecodings(s3) == 0);

        String s4 = "06";
        // expected output = 0
        System.out.println(solution.numDecodings(s4) == 0);

        String s5 = "123123";
        // expected output = 9
        System.out.println(solution.numDecodings(s5) == 9);
    }

    private static class Solution {

        public int numDecodings(String s) {

            int[] answer = new int[s.length()];
            int lastIdx = s.length() - 1;

            if (isValid(s.substring(lastIdx, lastIdx + 1)))
                answer[lastIdx] = 1;

            if (s.length() == 1)
                return answer[lastIdx];

            if (!isValid(s.substring(lastIdx - 1, lastIdx))) {
                answer[lastIdx - 1] = 0;
            } else if (isValid(s.substring(lastIdx - 1, lastIdx + 1))) {
                answer[lastIdx - 1] = answer[lastIdx] + 1;
            } else {
                answer[lastIdx - 1] = answer[lastIdx];
            }

            for (int i = lastIdx - 2, j = lastIdx - 1; i >= 0; i--, j--) {
                answer[i] += isValid(s.substring(i, j)) ? answer[j] : 0;
                answer[i] += isValid(s.substring(i, j + 1)) ? answer[j + 1] : 0;
            }

            return answer[0];
        }

        private boolean isValid(String split) {
            if (split.charAt(0) == '0')
                return false;

            int n = Integer.parseInt(split);
            return 1 <= n && n <= 26;
        }
    }


}
















