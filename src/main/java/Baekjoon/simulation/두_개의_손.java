package Baekjoon.simulation;

import java.util.Scanner;

public class 두_개의_손 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 민성 : ML, MR,  태경: TL, TR
        // S-0: 가위, R-1: 바위, P-2: 보
        // 민성 MS, 태경 TK, 확답할 수 없다면 “?”

        String[] split = sc.nextLine().split(" ");
        int ML = change(split[0]);
        int MR = change(split[1]);
        int TL = change(split[2]);
        int TR = change(split[3]);

        if (ML != MR && TL != TR) {
            System.out.println("?");

        } else if (ML == MR && TL != TR) {
            if (ML == S && (TL == R || TR == R))
                System.out.println("TK");
            else if (ML == P && (TL == S || TR == S))
                System.out.println("TK");
            else if (ML == R && (TL == P || TR == P))
                System.out.println("TK");
            else
                System.out.println("?");

        } else if (ML != MR && TL == TR) {
            if (TL == S && (ML == R || MR == R))
                System.out.println("MS");
            else if (TL == P && (ML == S || MR == S))
                System.out.println("MS");
            else if (TL == R && (ML == P || MR == P))
                System.out.println("MS");
            else
                System.out.println("?");

        } else {
            if (ML == S) {
                if (TL == P) System.out.println("MS");
                if (TL == S) System.out.println("?");
                if (TL == R) System.out.println("TK");
            }
            if (ML == R) {
                if (TL == P) System.out.println("TK");
                if (TL == S) System.out.println("MS");
                if (TL == R) System.out.println("?");
            }
            if (ML == P) {
                if (TL == P) System.out.println("?");
                if (TL == S) System.out.println("TK");
                if (TL == R) System.out.println("MS");
            }
        }
    }

    static final int S = 0;
    static final int R = 1;
    static final int P = 2;

    static int change(String action) {
        if (action.equals("S")) return S;
        if (action.equals("R")) return R;
        if (action.equals("P")) return P;
        return 0;
    }
}
