package concept_study.algorithm.graph.Tree.Parametric_Search;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_1654 {
    // 랜선 자르기

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//        int K = 4;
//        int N = 11;
//        int[] LANs = {802, 743, 457, 539};

        int K = sc.nextInt();
        int N = sc.nextInt();

        int[] LANs = new int[K];
        for (int i = 0; i < K; i++)
            LANs[i] = sc.nextInt();

        long answer = Integer.MIN_VALUE;
        long left = 1;
        long right = Arrays.stream(LANs).max().orElse(0);

        while (left <= right) {
            long mid = (left + right) / 2;

            if (isPossible(LANs, N, mid)) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static boolean isPossible(int[] LANs, int N, long max) {
        int cnt = 0;
        for (int LAN : LANs) {
            cnt += LAN / max;
        }
        return N <= cnt;
    }
}
