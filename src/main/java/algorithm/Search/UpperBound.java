package algorithm.Search;

/**
 * Upper bound search algorithm.
 * Upper bound is kind of binary search algorithm but:
 * -It returns index of first element which is grater than searched value.
 * -If searched element is bigger than any array element function returns first index after last element.
 * Behaviour for unsorted arrays is unspecified.
 * Complexity O(log n).
 */
public class UpperBound {
    // https://www.javatips.net/api/java-algorithms-implementation-master/src/com/jwetherell/algorithms/search/UpperBound.java

    // 특정 값보다 처음으로 큰 값이나 나오는 위치
    int upperBound(int[] array, int length, int value) {

        int low = 0;

        // note: 배열에 없는 큰수를 찾으려는 시도를 위해 length -1 이 아닌 length로 할당
        int high = length;

        while (low < high) {

            int mid = (low + high) / 2;

            if (value >= array[mid]) {

                // 찾은 값이 겉거나 작으면 low를 mid + 1  up 시킨다.
                low = mid + 1;

            } else {

                // 찾은 값이 더 크면 high를 mid down 시킨다.
                high = mid;
            }
        }

        return low;
    }
}