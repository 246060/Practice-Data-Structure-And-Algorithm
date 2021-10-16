package concept_study.algorithm.Search;

/**
 * Upper bound search concept.algorithm.
 * Upper bound is kind of binary search concept.algorithm but:
 * -It returns index of first element which is grater than searched value.
 * -If searched element is bigger than any array element function returns first index after last element.
 * Behaviour for unsorted arrays is unspecified.
 * Complexity O(log n).
 */
public class UpperBound {
    // https://www.javatips.net/api/java-algorithms-implementation-master/src/com/jwetherell/algorithms/search/UpperBound.java

    // 특정 값보다 처음으로 큰 값이나 나오는 위치
    int upperBound(int[] arr, int length, int value) {
        int l = 0;
        int r = length;
        // note: 배열에 없는 큰수를 찾으려는 시도를 위해 length -1 이 아닌 length로 할당

        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] <= value) {
                // 찾은 값이 겉거나 작으면 low를 mid + 1  up 시킨다.
                l = m + 1;
            } else {
                // 찾은 값이 더 크면 high를 mid down 시킨다.
                r = m;
            }
        }

        return l;
    }
}