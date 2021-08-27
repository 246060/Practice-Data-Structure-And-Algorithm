package algorithm.String;

import java.util.Arrays;

public class KMP2 {

    public static void main(String[] args) {

        String txt = "ababacabacaabacaaba";
        String pat = "abacaaba";
        kmp(txt, pat);
    }

    private static void kmp(String txt, String pat) {
        int[] table = table(pat);
        char[] txtArr = txt.toCharArray();
        int TN = txtArr.length;

        char[] patArr = pat.toCharArray();
        int PN = patArr.length;
        System.out.println("TXT : "+ Arrays.toString(txtArr));
        System.out.println("PAT : "+ Arrays.toString(patArr));
        System.out.println("TABLE : "+ Arrays.toString(table));

        int p = 0;
        for (int i = 0; i < TN; i++) {
            while (p > 0 && patArr[p] != txtArr[i]) {
                // 다르면 pattern 인덱스를 내리자!
                p = table[p - 1];
            }

            if (patArr[p] == txtArr[i]) {
                if (p == PN - 1) {
                    System.out.printf("%d번째에서 찾았습니다.\n", i - PN + 2);
                    p = table[p];
                } else {
                    p++;
                }
            }
        }
    }

    private static int[] table(String pat) {
        char[] patArr = pat.toCharArray();
        int[] table = new int[patArr.length];

        int k = 0;
        for (int i = 1; i < table.length; i++) {

            while (k > 0 && patArr[k] != patArr[i]) {
                k = table[k - 1];
            }

            if (patArr[k] == patArr[i]) {
                table[i] = ++k;
            }
        }

        return table;
    }


}
