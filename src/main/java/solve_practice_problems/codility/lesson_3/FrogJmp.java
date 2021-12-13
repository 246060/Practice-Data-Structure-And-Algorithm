package solve_practice_problems.codility.lesson_3;

public class FrogJmp {

    public static void main(String[] args) {

        int X, Y, D;

        X = 10;
        Y = 85;
        D = 30;
        System.out.println(solution(X, Y, D));

        X = 10;
        Y = 101;
        D = 30;
        System.out.println(solution(X, Y, D));
    }

    public static int solution(int X, int Y, int D) {
        int tmp = Y - X;
        if (tmp % D == 0) {
            return tmp / D;
        } else {
            return (tmp / D) + 1;
        }
    }
}
