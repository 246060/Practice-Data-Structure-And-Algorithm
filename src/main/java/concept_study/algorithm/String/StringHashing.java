package concept_study.algorithm.String;

public class StringHashing {

    public static void main(String[] args) {

        String txt = "AABAACAADAABAAABAA";

        backToFront(txt);
        frontToBack(txt);
    }

    static void backToFront(String txt) {
        final int d = 256;
        final int q = 101; // A prime number

        int N = txt.length();
        int answer = 0;

        for (int i = 0; i < N; i++) {
            answer = (d * txt.charAt(i) + answer) % q;
        }

        System.out.println(answer);
    }

    static void frontToBack(String txt) {
        final int d = 256;
        final int q = 101; // A prime number

        int N = txt.length();
        int answer = 0;

        for (int i = 0; i < N; i++) {
            answer = (d * answer + txt.charAt(i)) % q;
        }

        System.out.println(answer);
    }

    /*
     * https://withhamit.tistory.com/401
     * hash(s) = (s[0] + s[1]* p + s[2] * p2+ … + s[n-1] * pn-1) mod m
     * */
    long hash(String s) {

        final int p = 53;
        final int m = (int) 1e9 + 9; //10^9 + 9
        int hash_val = 0;
        int pow_p = 1;

        for (int i = 0; i < s.length(); i++) {
            hash_val = (hash_val + (s.charAt(i) - 'a' + 1) * pow_p) % m;
            pow_p = (p * pow_p) % m;
        }

        return hash_val;
    }
}
