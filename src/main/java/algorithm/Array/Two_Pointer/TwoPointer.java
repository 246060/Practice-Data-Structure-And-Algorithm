package algorithm.Array.Two_Pointer;

public class TwoPointer {

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

        for (int start = 0; start < n; start++) {
            while (subtotal < m && end < n) {
                subtotal += arr[end];
                end++;
            }
            if (subtotal == m) {
                cnt++;
            }
            subtotal -= arr[start];
        }

        System.out.println(cnt);
    }
}
