package Baekjoon.simulation;

import java.util.Scanner;

public class 탕수육 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            String[] split = sc.nextLine().split("");
            int len = split.length;

            int idx = 0;
            String alphabet = "";
            boolean[] visited = new boolean[len];
            while (true) {
                if (visited[idx]) break;
                visited[idx] = true;
                alphabet += split[idx];
                idx += 2;
                idx %= len;
            }
            System.out.println(alphabet);

            idx = len == 1 ? 0 : 1;
            alphabet = "";
            visited = new boolean[len];
            while (true) {
                if (visited[idx]) break;
                visited[idx] = true;
                alphabet += split[idx];
                idx += 2;
                idx %= len;
            }
            System.out.println(alphabet);
        }
    }
}
