package solve_practice_problems.Baekjoon.simulation;

import java.util.Scanner;

public class 영식이와_친구들 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();

        int[] counts = new int[N + 1];
        int cur = 1;
        int answer = 0;
        while (true) {
            counts[cur] += 1;

            if (counts[cur] == M) {
                break;
            } else if (counts[cur] % 2 == 1) { //odd
                cur += L;
                cur = cur > N ? cur - N : cur;
            } else { // even
                cur -= L;
                cur = cur <= 0 ? N + cur : cur;
            }

            answer += 1;
        }

        System.out.println(answer);
    }
}
