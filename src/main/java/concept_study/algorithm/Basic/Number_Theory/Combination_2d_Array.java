package concept_study.algorithm.Basic.Number_Theory;

/**
 * 2차원 배열에서 조합을 구할때 사용하는 방법
 * 완전 탐색 할때 사용
 */
public class Combination_2d_Array {

    static int n = 2;
    static int m = 3;

    public static void main(String[] args) {
        int[][] map = new int[n][m];

        print(map);
        int r = 4;
        comb(map, r, 0, 0);

    }

    static void comb(int[][] map, int r, int start, int depth) {
        if (depth == r) {
            print(map);
            return;
        }

        for (int i = start; i < n * m; i++) {
            int x = i / m;
            int y = i % m;

            if (map[x][y] == 0) {
                map[x][y] = 1;
                comb(map, r, i + 1, depth + 1);
                map[x][y] = 0;
            }
        }
    }

    static void print(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
