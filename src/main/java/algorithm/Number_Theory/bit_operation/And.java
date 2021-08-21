package algorithm.Number_Theory.bit_operation;

public class And {

    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(4 ^ 1));

        int K = 9;
        System.out.println(Integer.toBinaryString(K));
        System.out.println(Integer.toBinaryString(~K));
        System.out.println(Integer.toBinaryString(~K | 1));
        System.out.println(Integer.toBinaryString(-K));
        System.out.println(-K == (~K | 1));
        System.out.println(Integer.toBinaryString(K & -K));
        System.out.println();

        AND_연산자로_짝수홀수_판별();
    }

    static void AND_연산자로_짝수홀수_판별() {
        int n = 10;
        for (int i = 0; i < n; i++) {
            if (isEven(i)) {
                System.out.println("짝수 : " + i);
            } else if (isOdd(i)) {
                System.out.println("홀수 : " + i);
            }
        }
    }

    static boolean isOdd(int n) {
        return (n & 1) == 1;
    }

    static boolean isEven(int n) {
        return (n & 1) == 0;
    }
}
