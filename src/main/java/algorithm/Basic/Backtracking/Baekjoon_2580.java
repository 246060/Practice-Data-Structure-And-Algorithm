package algorithm.Basic.Backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2580 {
// 스도쿠 문제

    static int count;
    static int[][] sudoku;
    static boolean[][] visited = new boolean[9][9];
    static boolean isFinish = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sudoku = new int[9][9];

        for (int i = 0; i < sudoku.length; i++)
            sudoku[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < sudoku.length; i++)
            for (int j = 0; j < sudoku.length; j++)
                if (sudoku[i][j] != 0) {
                    visited[i][j] = true;
                    count++;
                }

        process(0);
    }


    static void process(int index) {

        if (count == 81) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < sudoku.length; i++) {
                for (int j = 0; j < sudoku[i].length; j++) {
                    sb.append(sudoku[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            isFinish = true;
            return;
        }

        if (isFinish)
            return;

        for (int i = index; i < 81; i++) {
            int r = i / 9;
            int c = i % 9;
            if (visited[r][c])
                continue;

            for (int j = 1; j <= 9; j++) {
                if (isPossible(r, c, j)) {
                    sudoku[r][c] = j;
                    visited[r][c] = true;
                    count++;
                    process(i);
                    sudoku[r][c] = 0;
                    visited[r][c] = false;
                    count--;
                }
            }

            if (sudoku[r][c] == 0) {
                return;
            }
        }
    }

    static boolean isPossible(int r, int c, int k) {

        // 행에 이미 숫자가 있는지 체크
        for (int i = 0; i < sudoku[r].length; i++)
            if (sudoku[r][i] == k)
                return false;

        // 열에 이미 숫자가 있는지 체크
        for (int i = 0; i < sudoku.length; i++)
            if (sudoku[i][c] == k)
                return false;

        // 사각형에 이미 숫자가 있는지 체크
        int nr = r / 3 * 3;
        int nc = c / 3 * 3;
        for (int i = nr; i < nr + 3; i++)
            for (int j = nc; j < nc + 3; j++)
                if (sudoku[i][j] == k)
                    return false;

        return true;
    }
}
