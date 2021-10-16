package concept_study.algorithm.Array;

import java.util.LinkedList;

public class Two_Pointer {

    public static void main(String[] args) {

        int n = 5; // 데이터 개수
        int m = 5; // 찾고자 하는 부분 합 M

        // 2,3
        // 3,2
        // 5
        int[] arr = {1, 2, 3, 2, 5};

        int cnt = 0;
        int subtotal = 0;
        int end = 0;
        LinkedList<Integer> answer = new LinkedList<>();

        for (int start = 0; start < n; start++) {

            while (subtotal < m && end < n) {
                subtotal += arr[end];
                answer.addLast(arr[end]);
                end++;
            }

            if (subtotal == m) {
                cnt++;
                System.out.format("%d : %s\n", cnt, answer);
            }

            subtotal -= arr[start];
            answer.removeFirst();
        }

        System.out.format("총 %d개", cnt);
    }
}
