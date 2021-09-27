package Coding_Test.NAVER.NAVER_FINANCIAL;

import java.util.HashMap;

public class Problem1 {

    public static void main(String[] args) {
        int[] A = new int[7];
        A[0] = 4;
        A[1] = 6;
        A[2] = 2;
        A[3] = 2;
        A[4] = 6;
        A[5] = 6;
        A[6] = 1;
        System.out.println(solution2(A));
    }

    static int solution2(int[] A) {
        int N = A.length;
        int result = 0;

        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                int[] before = map.get(A[i]);
                int len = i - before[0] + before[1];

                result = Math.max(result, len);
                map.put(A[i], new int[]{i, len});

            } else {
                map.put(A[i], new int[]{i, 0});
            }
        }

        return result;
    }

}
