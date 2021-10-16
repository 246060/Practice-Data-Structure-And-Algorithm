package concept_study.algorithm.Basic.Number_Theory.Prime_Number;

import java.util.ArrayList;
import java.util.Arrays;

public class EratosthenesSieve {

    public static void main(String[] args) {

        // 소수는 1과 자기자신으로 밖에 약수가 없다.
        // 즉 어떤 수의 곱으로 소수는 만들어지지 않는다.

        // n 범위 안의 소수 구하기 솔루션
        int n = 30;
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {

                // i의 배수만큼 건너뛰면서 소수 아님 처리
                for (int j = i + i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                result.add(i);
            }
        }
        
        System.out.println(result);
    }
}
