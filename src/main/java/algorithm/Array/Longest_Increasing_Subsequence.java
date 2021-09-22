package algorithm.Array;

import java.util.Arrays;
import java.util.LinkedList;

public class Longest_Increasing_Subsequence {

    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 1, 7, 4, 8, 3};
        // { 2, 5, 7, 8 }

        System.out.println(dp_lis(arr));
//        System.out.println(dp_lis_length(arr));
        System.out.println(binary_search_lis_length(arr));
//        System.out.println(Arrays.toString(dp_lis(arr)));
        System.out.println(binary_search_lis(arr));
    }

    static int dp_lis_length(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++)
                if (arr[j] < arr[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    static int[] dp_lis(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] path = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            path[i] = -1;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        path[i] = j;
                    }
                }
            }
        }

        int maxIdx = 0;
        for (int i = 0; i < dp.length; i++)
            if (dp[maxIdx] < dp[i])
                maxIdx = i;

        LinkedList<Integer> lis = new LinkedList<>();
        for (int i = maxIdx; i != -1; i = path[i])
            lis.addFirst(arr[i]);

        return lis.stream().mapToInt(Integer::intValue).toArray();
    }

    static int binary_search_lis(int[] arr) {

        int n = arr.length;
        int[] idxs = new int[n]; // LIS 사용가능한 숫자를 index 으로 저장
        int[] path = new int[n]; // 경로 역추적하기 위해
        path[0] = -1;  // 첫번째 -1 저장
        idxs[0] = 0;   // 첫번째 idx 저장

        int len = 1;   // LIS 개수 관리 변수
        for (int i = 1; i < n; i++) {

            if (arr[idxs[len - 1]] < arr[i]) {
                // LIS 배열의 마지막 숫자와 수열값을 비교

                path[i] = idxs[len - 1]; // 해당 위치를 path[i]에 넣음
                idxs[len++] = i;     // 제일 뒤에 index 붙임
            } else {

                // 넣을 위치를 확인
                int idx = binarySearch2(arr, idxs, 0, len - 1, arr[i]);
                if (idx < 0) {
                    idx = -idx - 1;
                }

                // 덮어쓸 위치의 index를 내것으로 복사
                path[i] = path[idxs[idx]];
                idxs[idx] = i;
            }
        }

        String str = "";
        int i = idxs[len - 1];
        while (i != -1) {
            str = arr[i] + " " + str;
            i = path[i];
        }

        System.out.println("LIS의 개수 : " + len);
        System.out.println("LIS의 경로 : " + str);
        return len;
    }

    static int binarySearch2(int[] arr, int[] indexs, int l, int r, int t) {
        while (l <= r) {
            int m = l + r >>> 1;
            if (arr[indexs[m]] < t) {
                l = m + 1;
            } else {
                if (arr[indexs[m]] <= t)
                    return m;
                r = m - 1;
            }
        }
        return -(l + 1);
    }

    static int binary_search_lis_length(int[] arr) {

        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0]; // dp 배열의 맨 첫번째 값은 arr[0]으로 초기화

        int j = 0;
        int i = 1;

        // arr의 두번째부터 마지막까지 하나씩 dp와 비교하면서 넣어준다.
        while (i < n) {

            // dp 배열의 맨 뒤의 값보다 arr[i]가 더 크면 그것을 dp 배열 맨 뒤에 넣어준다.
            if (dp[j] < arr[i]) {
                dp[++j] = arr[i];

            } else {
                // arr[i]값이 더 작으면, arr[i]의 값이 dp 배열 중 어느 곳에 들어올지 이분탐색한다.
                // 0부터 j까지 탐색하면서 arr[i]가 들어갈 수 있는 위치를 찾아서 idx에 반환
                dp[binarySearch(dp, 0, j, arr[i])] = arr[i];
            }

            i++;
        }

        return j + 1;
    }

    static int binarySearch(int[] dp, int l, int r, int t) {
        while (l < r) {
            int m = (l + r) / 2;

            if (dp[m] < t) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }
}
