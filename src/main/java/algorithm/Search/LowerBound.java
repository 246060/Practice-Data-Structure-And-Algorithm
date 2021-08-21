package algorithm.Search;

/**
 * Lower bound search algorithm.
 * Lower bound is kind of binary search algorithm but:
 * -If searched element doesn't exist function returns index of first element which is bigger than searched value.
 * -If searched element is bigger than any array element function returns first index after last element.
 * -If searched element is lower than any array element function returns index of first element.
 * -If there are many values equals searched value function returns first occurrence.
 * Behaviour for unsorted arrays is unspecified.
 * Complexity O(log n).
 */
public class LowerBound {
    // https://www.javatips.net/api/java-algorithms-implementation-master/src/com/jwetherell/algorithms/search/LowerBound.java

    int lowerBound(int[] array, int length, int value) {
        int low = 0;
        int high = length; // note: 배열에 없는 큰수를 찾으려는 시도를 위해 length -1 이 아닌 length로 할당

        while (low < high) {
            int mid = (low + high) / 2;

            if (value <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}






