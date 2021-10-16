package concept_study.algorithm.String;

public class Boyer_Moore_Horspool {
    // Note: Simplified_Boyer_Moore에서 2가지 수정한 알고리즘

    public static void main(String[] args) {
        char[] txt = "ABAAABCD".toCharArray();
        char[] pat = "ABC".toCharArray();
        search(txt, pat);
    }

    static int NO_OF_CHARS = 256;

    //The preprocessing function for Boyer Moore's bad character heuristic
    static void badCharHeuristic(char[] str, int size, int[] badchar) {

        // Initialize all occurrences as -1
        for (int i = 0; i < NO_OF_CHARS; i++)
            badchar[i] = -1;

        // Fill the actual value of last occurrence of a character
        // (indeces of table are ascii and values are index of occurence)
        // Note : 다른점 1 - Don't use the last char to compute badchar[]
        for (int i = 0; i < size - 1; i++) {
            badchar[(int) str[i]] = i;
        }
    }

    /* A pattern searching function that uses Bad Character Heuristic of Boyer Moore Algorithm */
    static void search(char[] txt, char[] pat) {

        int m = pat.length;
        int n = txt.length;
        int[] badchar = new int[NO_OF_CHARS];

        // Fill the bad character array by calling the preprocessing
        // function badCharHeuristic() for given pattern
        badCharHeuristic(pat, m, badchar);

        // s is shift of the pattern with
        int s = 0;

        // respect to text there are n-m+1 potential allignments
        while (s <= (n - m)) { // n-m : P가 이동할수 있는 최대 크기
            int j = m - 1;

            /* Keep reducing index j of pattern while characters of pattern and text are matching at this shift s */
            while (j >= 0 && pat[j] == txt[s + j]) {
                j--;
            }

            if (j < 0) {
                System.out.println("Patterns occur at shift = " + s);
                /* Shift the pattern so that the next character in text aligns with the last occurrence of it in pattern.
                 The condition s+m < n is necessary for the case when pattern occurs at the end of text */
                s += (s + m < n) ? m - badchar[txt[s + m]] : 1;
                // txt[s+m] is character after the pattern in text
            } else {
                /* ==========================================================
                   The character in T aligned with P[m-1] is: T[i0+(m-1))]
                   Always use character T[i0 + (m-1)] to find the shift
                   ========================================================== */
                // Note : 다른점 2
                s += Math.max(1, (m - 1) - badchar[txt[s + (m - 1)]]);
            }
        }
    }

}
