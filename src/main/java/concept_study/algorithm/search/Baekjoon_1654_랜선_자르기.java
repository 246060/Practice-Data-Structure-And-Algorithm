package concept_study.algorithm.search;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Parametric Search 문제
 * */
public class Baekjoon_1654_랜선_자르기 {

    // https://www.acmicpc.net/problem/1654
    public static void main(String[] args) {
        /*
        # input
        4 11
        802
        743
        457
        539

        모두 N개의 같은 길이의 랜선으로 만들고 싶었기 때문에 K개의 랜선을 잘라서 만들어야 한다.
        N개를 만들 수 있는 랜선의 최대 길이를 센티미터 단위의 정수로 출력

        # output
        200

        */
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();

        // 2^31 - 1 = 2,147,483,647
        int[] lines = new int[K];

        for (int i = 0; i < lines.length; i++) {
            // 이미 가지고 있는 각 랜선의 길이
            lines[i] = sc.nextInt();
        }

        Arrays.sort(lines);

        int s = 0, e = lines[lines.length - 1];

        int max = Integer.MIN_VALUE;
        while (s < e) {
            int mid = (s + e) / 2;

            int count = 0;
            for (int line : lines) {
                count += line / mid;
            }

            if (count < N) {
                // mid down
                e = mid;
            } else {
                // mid up
                s = mid + 1;
                max = Math.max(max, mid);
            }
        }

        System.out.println(max);
    }
}
