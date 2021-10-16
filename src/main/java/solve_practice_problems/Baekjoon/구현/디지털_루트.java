package solve_practice_problems.Baekjoon.구현;

import java.math.BigInteger;
import java.util.Scanner;

public class 디지털_루트 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            BigInteger num = sc.nextBigInteger();
            if (num.compareTo(BigInteger.ZERO) == 0) break;

            BigInteger result = BigInteger.ZERO;
            while (true) {

                while (num.compareTo(BigInteger.ZERO) == 1) {
                    BigInteger tmp = num.mod(BigInteger.valueOf(10));
                    result = result.add(tmp);
                    num = num.divide(BigInteger.valueOf(10));
                }

                if (result.compareTo(BigInteger.valueOf(9)) == 1) {
                    num = result;
                    result = BigInteger.ZERO;
                } else {
                    break;
                }
            }
            System.out.println(result);
        }
    }

}
