package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 줄_세기_4806 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt = 0;

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.equals("EOF")) {
                break;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
