package algorithm.Basic.Number_Theory;

public class GCD_LCM {
    /*
     * 유클리드 호제법
     * # 최대 공약수
     * 두 개의 자연수 a와 b에서(단 a>b) a를 b로 나눈 나머지를 r 이라고 했을때,
     * GCD(a, b) = GCD(b, r)과 같고 r이 0이면 그때 b가 최대공약수이다.
     *
     * GCD(24,16) -> GCD(16,8) -> GCD(8,0) : 최대공약수 = 8
     *
     * # 최소 공배수
     * = a x b / GCD(a, b)
     *
     * */

    public static void main(String[] args) {
        int a = 25, b = 5;
        System.out.println(String.format("gcd(b,a) = %d", gcd(b, a)));
        System.out.println(String.format("lcm(b,a) = %d", lcm(b, a)));
    }


    static int gcd(int a, int b) {
        if (a < b) {
            int t = b;
            b = a;
            a = t;
        }

        while (true) {
            int r = a % b;
            if (r == 0) return b;
            a = b;
            b = r;
        }
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
