package concept_study.algorithm.mathematics.Prime_Number;

public class PrimeNumber {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            if (isPrime(i)) {
                System.out.println(i + "는 소수");
            }
        }
    }

    static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

}
