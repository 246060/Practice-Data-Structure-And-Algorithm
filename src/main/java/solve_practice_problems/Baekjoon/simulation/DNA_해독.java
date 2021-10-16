package solve_practice_problems.Baekjoon.simulation;

import java.util.HashMap;
import java.util.Scanner;

public class DNA_해독 {

    public static void main(String[] args) {

        HashMap<String, Character> dic = new HashMap<>();
        dic.put("AA", 'A');
        dic.put("AG", 'C');
        dic.put("AC", 'A');
        dic.put("AT", 'G');
        dic.put("GA", 'C');
        dic.put("GG", 'G');
        dic.put("GC", 'T');
        dic.put("GT", 'A');
        dic.put("CA", 'A');
        dic.put("CG", 'T');
        dic.put("CC", 'C');
        dic.put("CT", 'G');
        dic.put("TA", 'G');
        dic.put("TG", 'A');
        dic.put("TC", 'G');
        dic.put("TT", 'T');

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String dna = sc.nextLine();

        char last = dna.charAt(dna.length() - 1);
        for (int i = N - 2; i >= 0; i--) {
            char cur = dna.charAt(i);
            last = dic.get(String.valueOf(cur) + String.valueOf(last));
        }

        System.out.println(last);
    }
}
