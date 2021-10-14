package algorithm.Search;

// 보간 탐색
public class InterpolationSearch2 {
    // https://yoongrammer.tistory.com/77

    // 정렬된 리스트에서 범위를 줄여가며 검색하는 알고리즘입니다.
    // 보간 검색은 전화부에서 이름 (책의 항목이 정렬되는 키 값)을 검색하는 방법과 유사합니다.
    // 동작 방식은 이진 탐색과 비슷하지만 탐색 위치를 정하는 방식이 다릅니다.

    // Operation	Best	Average	        Worst
    // Search	    O(1)	Θ(log(log n))	O(n)

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int key = 8;

        System.out.println(interpolationSearch(arr, arr.length, key));
    }

    static int interpolationSearch(int arr[], int n, int x) {

        int low = 0, high = (n - 1);
        int pos = 0;

        while (arr[low] != arr[high] && arr[low] <= x && x <= arr[high]) {
            pos = (int) (low + (((double) (high - low) / (arr[high] - arr[low])) * (x - arr[low])));

            if (arr[pos] == x)
                return pos;
            else if (arr[pos] > x)
                high = pos - 1;
            else
                low = pos + 1;
        }

        if (x == arr[low])
            return low;
        else
            return -1;
    }

}






