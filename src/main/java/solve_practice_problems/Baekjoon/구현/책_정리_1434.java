package solve_practice_problems.Baekjoon.구현;

import java.util.Arrays;
import java.util.Scanner;

public class 책_정리_1434 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] boxes = new int[N];
        int[] books = new int[M];

        for (int i = 0; i < N; i++) {
            boxes[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            books[i] = sc.nextInt();
        }

        for (int bookCur = 0, boxCur = 0; bookCur < M && boxCur < N; bookCur++) {
            if (boxes[boxCur] >= books[bookCur]) {
                boxes[boxCur] -= books[bookCur];
            } else {
                boxCur++;
                bookCur--;
            }
        }

        System.out.println(Arrays.stream(boxes).sum());
    }
}
