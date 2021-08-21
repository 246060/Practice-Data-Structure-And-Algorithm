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

    int upperBound(int[] array, int length, int value) {
        int low = 0;
        int high = length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (value >= array[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}