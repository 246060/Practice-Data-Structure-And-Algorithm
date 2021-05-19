package algorithm.Number_Theory.bit_operation;

public class Xor {

    public static void main(String[] args) {

        // XOR 연산의 특징
        // - 두 값의 각 자릿수를 비교해, 값이 같으면 0, 다르면 1을 계산한다.
        // - 0과 어떤 값 A를  XOR 하면 A가 나온다.
        // - A^B=C 이고, C^A=B이고, A^C=B 이다.

        int A = 14;
        int B = 17;
        int C = A ^ B;
        System.out.println("A : " + Integer.toBinaryString(A));
        System.out.println("B : " + Integer.toBinaryString(B));

        System.out.println("A^B=C : " + Integer.toBinaryString(C));
        System.out.println("C^A=B : " + Integer.toBinaryString(C ^ A));
        System.out.println("C^B=A : " + Integer.toBinaryString(C ^ B));
    }
}
