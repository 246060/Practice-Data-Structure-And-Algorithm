package algorithm.Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_12865_Plain_Backpack {
    static int[] weights;
    static int[] values;

    public static void main(String[] args) {
        // 한 줄에 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 출력
        Scanner scanner = new Scanner(System.in);
        int[] nums = getLine(scanner.nextLine());

        int n = nums[0];
        int k = nums[1];

        weights = new int[n + 1];
        values = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            if (i == 0) {
                weights[0] = 0;
                values[0] = 0;
            } else {
                nums = getLine(scanner.nextLine());
                weights[i] = nums[0];
                values[i] = nums[1];
            }
        }

        int[][] matrix = new int[weights.length][k + 1];

        int lastR = 0, lastC = 0;
        for (int r = 1; r < weights.length; r++) {
            for (int c = 1; c < matrix[r].length; c++) {
                int toLeft = 0;
                if (c - weights[r] >= 0) {
                    toLeft = matrix[r - 1][c - weights[r]] + values[r];
                }
                int toDown = matrix[r - 1][c];

                matrix[r][c] = Math.max(toLeft, toDown);
                lastR = r;
                lastC = c;
            }
        }

        System.out.println(matrix[lastR][lastC]);
    }


    private static int[] getLine(String line) {
        return Arrays.stream(line.split(" "))
                     .mapToInt(Integer::valueOf)
                     .toArray();
    }
}
