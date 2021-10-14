package algorithm.Search;

public class SequentialSearch {
    // https://yoongrammer.tistory.com/74?category=987044
    // Operation	Best	Average	  Worst
    // Search	    O(1)	Θ(n)	  O(n)

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int key = 8;

        System.out.println(sequentialSearch(arr, arr.length, key));
    }

    static int sequentialSearch(int[] arr, int n, int key) {
        int i = 0;
        while (true) {
            if (i == n) return -1;  // 종료 조건 1. 검색 실패
            if (arr[i] == key) return i; // 종료 조건 2. 검색 성공
            i++;
        }
    }

    /*
     * 보초 법 (Sentinel method)
     * 보초 법이란 반복의 종료를 알리는 특정한 값인
     * 보초(Sentinel) 값을 사용하여 종료 조건중
     * 검색 실패 조건을 제거하여 판단 횟수를 줄이는 방법입니다.
     * */
    static int sentinelLinearSearch(int[] arr, int n, int key) {
        int i = 0;
        arr[n] = key;  // 배열 마지막에 보초값 추가

        while (true) {
            if (arr[i] == key) break; // 종료 조건 2. 검색 성공
            i++;
        }
        return i == n ? -1 : i; // 보초값이면 -1 리턴, 아니면 요소의 인덱스 리턴
    }
}
