package solve_practice_problems.Baekjoon.Two_Point;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_1644_소수의_연속합 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        int e = 2;
        int sum = 0, count = 0;

        while (true) {
            if (sum >= N) {
                sum -= q.poll();
            } else if (e > N) {
                break;
            } else {
                while (!isPrime(e)) e++;
                sum += e;
                q.offer(e);
                e++;
            }

            if (sum == N) count++;
        }

        System.out.println(count);
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
