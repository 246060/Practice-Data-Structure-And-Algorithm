package solve_practice_problems.Baekjoon.구현;

import java.util.Arrays;
import java.util.Scanner;

public class 음계 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().replaceAll(" ", "").toCharArray();
        String origin = String.valueOf(arr);

        char[] copy = arr.clone();
        Arrays.sort(copy);
        String acs = String.valueOf(copy);
        String desc = new StringBuilder(new String(copy)).reverse().toString();

        if (origin.equals(acs)) {
            System.out.println("ascending");
        } else if (origin.equals(desc)) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
