package solve_practice_problems.Baekjoon.backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon_1759 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();

        String[] text = sc.nextLine().split(" ");

        backtracking(0, L, text, new ArrayList<>());

        answer.sort(String::compareTo);
        answer.forEach(System.out::println);
    }

    static ArrayList<String> answer = new ArrayList<>();

    static void backtracking(int level, int L, String[] text, ArrayList<String> result) {
        if (L == result.size()) {
            if (validCheck(result)) {
                ArrayList<String> tmp = new ArrayList<>(result);
                tmp.sort(String::compareTo);
                answer.add(String.join("", tmp));
            }
            return;
        }

        for (int i = level; i < text.length; i++) {
            result.add(text[i]);
            backtracking(i + 1, L, text, result);
            result.remove(result.size() - 1);
        }
    }

    static boolean validCheck(ArrayList<String> answer) {
        int ConsonantsCnt = 0;
        int VowelsCnt = 0;
        for (String o : answer) {
            if (isConsonants(o))
                ConsonantsCnt++;
            else
                VowelsCnt++;
        }

        return ConsonantsCnt >= 2 && VowelsCnt >= 1;
    }

    static boolean isConsonants(String o) {
        return !isVowels(o);
    }

    static boolean isVowels(String o) {
        if (o.equals("a")) return true;
        if (o.equals("e")) return true;
        if (o.equals("i")) return true;
        if (o.equals("o")) return true;
        return o.equals("u");
    }
}
