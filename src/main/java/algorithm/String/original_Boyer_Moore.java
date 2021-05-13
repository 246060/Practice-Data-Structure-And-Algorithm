package algorithm.String;

public class original_Boyer_Moore {
    // https://greatzzo.tistory.com/8
    // https://www.geeksforgeeks.org/boyer-moore-algorithm-good-suffix-heuristic/

    public static void main(String[] args) {

        char[] txt = "AABAACAADAABAAABAA".toCharArray();
        char[] pat = "AABA".toCharArray();

        searchBM(pat, txt);
    }

    static final int NUM_OF_CHARS = 256;

    static void searchBM(char[] pat, char[] txt) {

        int N = txt.length;
        int M = pat.length;

        int[] bc = createBC(pat, M);
        int[] gs = createGS(pat, M);

        int s = 0; // Shift of the pattern with respect to text
        int j = 0; // Index for pat[]

        while (s <= (N - M)) {
            j = M - 1;

            // Keep reducing index j of pattern while characters of
            // pattern and text are matching at this shift s
            while (j >= 0 && pat[j] == txt[s + j])
                j--;

            if (j < 0) {
                System.out.format("Pattern found at index %d \n", s);
                // Shift the pattern as the length of the maximum full suffix in pattern.
                s += gs[0];
            } else {
                // Shift the pattern as max of bad character and good suffix.
                // So, bad character or good suffix in text aligns with the last　occurrence of it in pattern.
                s += Math.max(j - bc[txt[s + j]], gs[j]);
            }
        }
    }


    // The preprocessing function for Boyer Moore's bad character heuristic
    static int[] createBC(char[] pat, int M) {
        int[] bc = new int[NUM_OF_CHARS];

        // Initialize all occurrences as -1
        for (int i = 0; i < NUM_OF_CHARS; i++) {
            bc[i] = -1;
        }

        // Fill the actual value of last occurrence of a character
        for (int i = 0; i < M - 1; i++) {
            bc[(int) pat[i]] = i;
        }

        return bc;
    }

    // The preprocessing function for Boyer Moore's good suffix heuristic
    static int[] createGS(char[] pat, int M) {

        int[] gs = new int[M];

        int i; // index for pattern suffix
        int j = 0; // index for partial pattern suffix

        // initialize gs array
        for (i = 0; i < M; i++) {
            gs[i] = M;
        }

        i = M - 1;
        while (i > 0) {
            if (j >= 0 && pat[i + j] == pat[j]) {
                j--;
            } else {
                if (j < 0) {
                    // case 1. partial good suffix matches prefix of pattern
                    for (; i + j >= 0; --j) {
                        gs[i + j] = i;
                    }
                } else {
                    // case 2. good suffix matches somewhere in the pattern
                    // set i to the shift length in gs[] element　whose index is the unmatched position
                    gs[i + j] = i;
                }
                j = M - i;
                i--;
            }
        }
        return gs;
    }

    /*　－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－　*/

    static class BadCharacterHeuristic {
        static final int NUM_OF_CHARS = 256;

        public static void main(String[] args) {

            char[] txt = "ABABBBACABAAB".toCharArray();
            char[] pat = "ABAAB".toCharArray();

            searchBM(pat, txt);
        }

        // The preprocessing function for Boyer Moore's bad character heuristic
        static int[] createBC(char[] pat, int M) {
            int[] bc = new int[NUM_OF_CHARS];

            // Initialize all occurrences as -1
            for (int i = 0; i < NUM_OF_CHARS; i++) {
                bc[i] = -1;
            }

            // Fill the actual value of last occurrence of a character
            for (int i = 0; i < M - 1; i++) {
                bc[(int) pat[i]] = i;
            }

            return bc;
        }

        static void searchBM(char[] pat, char[] txt) {
            int N = txt.length;
            int M = pat.length;

            int[] bc = createBC(pat, M);
            int s = 0; // Shift of the pattern with respect to text
            int j = 0; // Index for pat[]

            while (s <= (N - M)) {
                j = M - 1;

                while (j >= 0 && pat[j] == txt[s + j]) {
                    j--;
                }

                if (j < 0) {
                    System.out.format("Pattern found at index %d \n", s);
                    // Shift the pattern so that the next character in text
                    // aligns with the last occurrence of it in pattern.

                    s += (s + M < N) ? M - bc[txt[s + M]] : 1;

                } else {
                    // Shift the pattern so that the bad character in text
                    // aligns with the last occurrence of it in pattern. The
                    // max function is used to make sure that we get a positive shift.
                    // We may get a negative shift if the last occurrence of bad character
                    // in pattern is on the right side of the current character.

                    s += Math.max(1, j - bc[txt[s + j]]);
                }
            }
        }
    }


    static class GoodSuffixHeuristic {

        public static void main(String[] args) {

            char[] txt = "AABBBAACABACBA".toCharArray();
            char[] pat = "ABACBA".toCharArray();

            searchBM(pat, txt);
        }

        static int[] createGS(char[] pat, int M) {
            int[] gs = new int[M];
            int i; // index for pattern suffix
            int j = 0; // index for partial pattern suffix

            // initialize gs array
            for (i = 0; i < M; i++) {
                gs[i] = M;
            }

            i = M - 1;
            while (i > 0) {
                if (j >= 0 && pat[i + j] == pat[j]) {
                    j--;
                } else {
                    if (j < 0) {
                        // case 1. partial good suffix matches prefix of pattern
                        for (; i + j >= 0; --j) {
                            gs[i + j] = i;
                        }
                    } else {
                        // case 2. good suffix matches somewhere in the pattern
                        // set i to the shift length in gs[] element
                        // whose index is the unmatched position
                        gs[i + j] = i;
                    }
                    j = M - i;
                    i--;
                }
            }
            return gs;
        }

        static void searchBM(char[] pat, char[] txt) {
            int N = txt.length;
            int M = pat.length;
            int[] gs = createGS(pat, M);
            int s = 0; // Shift of the pattern with respect to text
            int j = 0; // Index for pat[]

            while (s <= (N - M)) {
                j = M - 1;

                // Keep reducing index j of pattern while characters of
                // pattern and text are matching at this shift s
                while (j >= 0 && pat[j] == txt[s + j]) {
                    j--;
                }

                if (j < 0) {
                    System.out.format("Pattern found at index %d \n", s);

                    // Shift the pattern as the length of the maximum full suffix in pattern.
                    s += gs[0];
                } else {
                    // Shift the pattern so that the good suffix in text
                    // aligns with the last occurrence of it in pattern.
                    s += gs[j];
                }
            }
        }
    }
}
