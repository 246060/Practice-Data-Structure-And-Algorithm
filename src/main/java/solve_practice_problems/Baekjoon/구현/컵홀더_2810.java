package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 컵홀더_2810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        char[] arr = sc.nextLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'S') {
                sb.append("*S*");
            } else {
                sb.append("*LL*");
                i++;
            }
        }

        String ans = sb.toString().replaceAll("\\*\\*", "*");
        int cnt = 0;
        arr = ans.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '*') cnt++;
        }
        System.out.println(cnt > N ? N : cnt);
    }
}
