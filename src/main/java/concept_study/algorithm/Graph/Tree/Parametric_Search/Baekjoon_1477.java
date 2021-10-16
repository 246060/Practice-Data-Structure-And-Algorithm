package concept_study.algorithm.Graph.Tree.Parametric_Search;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_1477 {

    public static void main(String[] args) {
//        int N = 6;
//        int M = 7;
//        int L = 800;
//        int[] restAreas = {0, 622, 411, 201, 555, 755, 82, 800};

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();

        int[] restAreas = new int[N + 2];

        restAreas[0] = 0;
        restAreas[1] = L;
        for (int i = 2; i < N + 2; i++)
            restAreas[i] = sc.nextInt();

        Arrays.sort(restAreas);

        int left = 1;
        int right = L;
        int answer = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(restAreas, M, mid)) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static boolean isPossible(int[] restAreas, int M, int max) {

        int cnt = 0;
        int prev = restAreas[0];

        for (int i = 1; i < restAreas.length; i++) {
            int tmp = restAreas[i] - prev;

            if (tmp % max == 0)
                cnt += (tmp / max) - 1;
            else
                cnt += tmp / max;

            prev = restAreas[i];
        }

        return cnt <= M;
    }
}
