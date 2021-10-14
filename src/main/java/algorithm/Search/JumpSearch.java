package algorithm.Search;

public class JumpSearch {
    // https://yoongrammer.tistory.com/76?category=987044
    // Operation  Best	 Average  Worst
    // Search	  O(1)	 Θ(√n)	  O(√n)

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int key = 8;

        System.out.println(jumpSearch(arr, arr.length, key));
    }

    static int jumpSearch(int arr[], int n, int key) {
        // 점프하기 위한 블록 크기 m을 구함.
        int m = (int) Math.sqrt(n);
        int prev = 0;

        // 블록 크기 만큼 점프하면서 key값을 포함하는 블록을 찾음
        while (arr[Math.min(m, n) - 1] < key) {
            prev = m;
            m += m; // 블록 크기 만큼 점프.

            if (prev >= n) // 배열 인덱스를 초과하는 경우, 검색 실패
                return -1;
        }

        // key값을 포함한 블록을 찾았다면
        // 블록의 첫번째 인덱스부터 선형 탐색 시작
        while (arr[prev] < key) {
            prev++;

            if (prev == Math.min(m, n)) // 블록 범위를 초과하는 경우, 검색 실패
                return -1;
        }

        // 검색 값을 찾은 경우
        if (arr[prev] == key)
            return prev;

        return -1;
    }
}
