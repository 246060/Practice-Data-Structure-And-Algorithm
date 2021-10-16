package solve_practice_problems.Baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_13904 {
    public static void main(String[] args) {

        int[] D = new int[1000 + 1];

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (o1, o2) -> o2[1] - o1[1]);

        for (int i = 0; i < N; i++) {
            int d = arr[i][0];

            if (D[d] == 0) {
                D[d] = arr[i][1];
            } else {

                // 빈 자리가 있는 곳 까지 인덱스 이동
                while (D[--d] > 0) ;

                // 1<=d<=1000 이므로 0번째 자리 제외
                if (d != 0) {
                    D[d] = arr[i][1];
                }
            }
        }

        int ans = Arrays.stream(D).sum();
        System.out.println(ans);
    }
}
