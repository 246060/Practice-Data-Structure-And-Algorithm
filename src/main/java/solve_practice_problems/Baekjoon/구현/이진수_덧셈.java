package solve_practice_problems.Baekjoon.구현;

import java.math.BigInteger;
import java.util.Scanner;

public class 이진수_덧셈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger a = new BigInteger(sc.next(), 2);
        BigInteger b = new BigInteger(sc.next(), 2);

        BigInteger c = a.add(b);
        System.out.println(c.toString(2));
    }
}
