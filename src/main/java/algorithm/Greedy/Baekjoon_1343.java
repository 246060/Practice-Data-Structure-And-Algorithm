package algorithm.Greedy;

import java.util.Scanner;

public class Baekjoon_1343 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;

        for (int i = 0; i < str.length() + 1; i++) {
            if (i < str.length() && str.charAt(i) == 'X') {
                count++;
            } else {

                if (count == 0) {
                    continue;
                }

                if (count % 2 != 0) {
                    System.out.println(-1);
                    return;
                }

                while (count / 2 != 0) {
                    if (count / 4 > 0) {
                        str = str.replaceFirst("XXXX", "AAAA");
                        count -= 4;
                    } else if (count / 2 > 0) {
                        str = str.replaceFirst("XX", "BB");
                        count -= 2;
                    }
                }

            }
        }

        System.out.println(str);
    }
}
