package solve_practice_problems.Baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_12865_Plain_Backpack {

    // 한 줄에 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 출력

    // 2차원 배열로 해결
    // bottom-up 방식

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = getLine(scanner.nextLine());

        int n = nums[0];
        int k = nums[1];

        int[] weights = new int[n + 1];
        int[] values = new int[n + 1];
        weights[0] = 0;
        values[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            nums = getLine(scanner.nextLine());
            weights[i] = nums[0];
            values[i] = nums[1];
        }

        int[][] matrix = new int[weights.length][k + 1];

        int answer = 0;
        for (int r = 1; r < weights.length; r++) {
            for (int c = 1; c < matrix[r].length; c++) {

                int leafOne = matrix[r - 1][c];
                int leafTwo = c - weights[r] < 0 ? 0 : values[r] + matrix[r - 1][c - weights[r]];

                answer = matrix[r][c] = Math.max(leafOne, leafTwo);
            }
        }

        System.out.println(answer);
    }


    private static int[] getLine(String line) {
        return Arrays.stream(line.split(" "))
                     .mapToInt(Integer::valueOf)
                     .toArray();
    }
}
