package concept_study.algorithm.Graph.Tree.Parametric_Search;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2110 {
    // 공유기 설치

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int answer = Integer.MIN_VALUE;

        // int N = 5;
        // int C = 3;
        // int[] homes = {1, 2, 8, 4, 9};

        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] homes = new int[N];

        for (int i = 0; i < N; i++)
            homes[i] = sc.nextInt();

        Arrays.sort(homes);

        int left = 0;
        int right = homes[homes.length - 1] - homes[0];

        while (left <= right) {
            int mid = (left + right) / 2;

            // 후보 최대거리는 확인한다.
            if (isPossible(homes, C, mid)) {
                // 유효한 후보 최대거리와 이전의 것을 비교 max값 조정
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static boolean isPossible(int[] homes, int C, int K) {

        // K는 공유기 최소 거리
        // K거리 이상의 집마다 공유기 설치하고 공유기 갯수(count++) 추가 해준다.
        int cnt = 1;

        for (int i = 1, prev = homes[0]; i < homes.length; i++) {
            int sub = homes[i] - prev;
            if (sub >= K) {
                cnt++;
                prev = homes[i];
            }
        }
        return cnt >= C;
    }
}
