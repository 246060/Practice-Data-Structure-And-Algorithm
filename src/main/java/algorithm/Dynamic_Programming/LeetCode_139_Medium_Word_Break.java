package algorithm.Dynamic_Programming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LeetCode_139_Medium_Word_Break {

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s1 = "leetcode";
        List<String> wordDict1 = List.of("leet", "code");
        // expected output = true
        System.out.println(solution.wordBreak(s1, wordDict1));

        String s2 = "applepenapple";
        List<String> wordDict2 = List.of("apple", "pen");
        // expected output = true
        System.out.println(solution.wordBreak(s2, wordDict2));

        String s3 = "catsandog";
        List<String> wordDict3 = List.of("cats", "dog", "sand", "and", "cat");
        // expected output = false
        System.out.println(solution.wordBreak(s3, wordDict3));

        String s4 =
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict4 = List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        // expected output = false
        System.out.println(solution.wordBreak(s4, wordDict4));
    }

    private static class Solution {
        HashSet<String> dic;
        HashMap<String, Boolean> memo;

        public boolean wordBreak(String s, List<String> wordDict) {
            dic = new HashSet<>(wordDict);
            memo = new HashMap<>();
            return isValid(0, s);
        }

        private boolean isValid(int index, String s) {
            if (index >= s.length())
                return true;

            boolean exist = false;
            for (int i = index; i < s.length(); i++) {
                if (exist) break;

                String word = s.substring(index, i + 1);
                exist = dic.contains(word);
                if (!exist) continue;

                String next = s.substring(i + 1);
                if (memo.containsKey(next)) {
                    exist = memo.get(next);
                } else {
                    exist = isValid(i + 1, s);
                }
            }

            memo.put(s.substring(index), exist);
            return exist;
        }
    }
}