package solve_practice_problems.Baekjoon.구현;

public class 싱기한_네자리_숫자 {
    public static void main(String[] args) {

        for (int i = 1000; i < 10000; i++) {
            int a = sum(i, 10);
            int b = sum(i, 12);
            int c = sum(i, 16);
            if (a == b && b == c) {
                System.out.println(i);
            }
        }
    }

    static int sum(int n, int r) {
        int sum = 0;
        while (n > 0) {
            sum += n % r;
            n /= r;
        }
        return sum;
    }
}
